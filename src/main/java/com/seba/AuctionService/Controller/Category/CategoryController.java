package com.seba.AuctionService.Controller.Category;

import com.seba.AuctionService.Entities.DAO.PictureDAO;
import com.seba.AuctionService.Entities.Product.Category;
import com.seba.AuctionService.Entities.Product.DTO.CategoryDTO;
import com.seba.AuctionService.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "admin/listofcategory", method = RequestMethod.GET)
    public ModelAndView listOfCategory(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/listofcategory");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addcategory", method = RequestMethod.GET)
    public ModelAndView addCategory(){
        ModelAndView modelAndView = new ModelAndView();
        Category category = new Category();
        PictureDAO pictureDAO = new PictureDAO();
        List<CategoryDTO> categoriesDTO = categoryService.findAllCategoryDTO();
        modelAndView.addObject("categoriesDTO", categoriesDTO);
        modelAndView.addObject("category", category);
        modelAndView.addObject("pictureDAO", pictureDAO);
        modelAndView.setViewName("admin/addcategory");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addcategory", method = RequestMethod.POST)
    public ModelAndView addCategoryPost(Category category, PictureDAO pictureDAO) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            category.setPicture(pictureDAO.getPictureDAO().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        categoryService.save(category);
        Category parentCategory = categoryService.findByID(category.getParentID());
        parentCategory.getSubCategories().add(category);
        categoryService.save(parentCategory);
        modelAndView.setViewName("redirect:/admin/listofcategory");
        return modelAndView;
    }


    public void listOfCategoryWithLevel(Category[] categories, int index, int level){

        if(index == categories.length)
            return;

        for (int i = 0; i < level; i++)
            System.out.print("\t");

        if(categories[index].getSubCategories().isEmpty())
            System.out.println(categories[index].getName());

        else if(!categories[index].getSubCategories().isEmpty())
        {
            System.out.println("[" + categories[index].getName() + "]");
            listOfCategoryWithLevel( categories[index].getSubCategories().toArray(new Category[0]), 0, level + 1);
        }

        listOfCategoryWithLevel(categories, ++index, level);


    }



}