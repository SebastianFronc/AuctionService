package com.seba.AuctionService.Controller.Category;

import com.seba.AuctionService.Entities.Product.Category;
import com.seba.AuctionService.Entities.Product.DTO.CategoryDTO;
import com.seba.AuctionService.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/admin/listofcategory", method = RequestMethod.GET)
    public ModelAndView listOfCategory(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("admin/listofcategory");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addcategory", method = RequestMethod.GET)
    public ModelAndView addCategory(){
        ModelAndView modelAndView = new ModelAndView();
        Category category = new Category();
        List<CategoryDTO> categoriesDTO = categoryService.findAllCategoryDTO();
        modelAndView.addObject("categoriesDTO", categoriesDTO);
        modelAndView.addObject("category", category);
        modelAndView.setViewName("admin/addcategory");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addcategory", method = RequestMethod.POST)
    public ModelAndView addCategoryPost(Category category, CategoryDTO categoryDTO){
        ModelAndView modelAndView = new ModelAndView();
        category.setParentCategory(categoryService.findByID(categoryDTO.getId()));
        Category parentCategory = category.getParentCategory();
        parentCategory.getSubCategories().add(category);
        categoryService.save(category);
        categoryService.save(parentCategory);
        modelAndView.setViewName("redirect:/listofcategory");
        return modelAndView;
    }


}
