package com.seba.AuctionService.controller.category;

import com.seba.AuctionService.entities.product.Category;
import com.seba.AuctionService.entities.product.dto.CategoryDTO;
import com.seba.AuctionService.entities.product.dto.CategoryForm;
import com.seba.AuctionService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/admin/addcategory", method = RequestMethod.GET)
    public ModelAndView addCategory(){
        ModelAndView modelAndView = new ModelAndView();
        CategoryForm categoryForm = new CategoryForm();
        List<CategoryDTO> categoriesDTO = categoryService.findAllCategoryDTO();
        modelAndView.addObject("categoriesDTO", categoriesDTO);
        modelAndView.addObject("categoryForm", categoryForm);
        modelAndView.setViewName("admin/addcategory");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addcategory", method = RequestMethod.POST)
    public ModelAndView addCategoryPost(CategoryForm categoryForm) {
        ModelAndView modelAndView = new ModelAndView();
        Category category = categoryForm.getCategory();
        try {
            category.setPicture(categoryForm.getPictureDAO().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Category parent = categoryService.findByID(categoryForm.getSlectedCategoryDTO().getIdDTO());
        category.setParent(parent);
        categoryService.save(category);
        parent.getSubCategories().add(category);
        categoryService.save(parent);
        modelAndView.setViewName("redirect:/admin/listofcategory");
        return modelAndView;
    }

    @RequestMapping(value = "admin/listofcategory", method = RequestMethod.GET)
    public ModelAndView listOfCategory(){
        ModelAndView modelAndView = new ModelAndView();
        Category mainCategory = categoryService.findByID(0);
        Set<Category> mainSubCategories = mainCategory.getSubCategories();
        modelAndView.addObject("subMainCategories", mainSubCategories);
        modelAndView.setViewName("admin/listofcategory");
        return modelAndView;
    }







}