package com.seba.AuctionService.controller.product;

import com.seba.AuctionService.entities.product.Product;
import com.seba.AuctionService.entities.product.dto.CategoryDTO;
import com.seba.AuctionService.entities.product.dto.ProductForm;
import com.seba.AuctionService.entities.user.TypeUser;
import com.seba.AuctionService.entities.user.User;
import com.seba.AuctionService.service.AuctionService;
import com.seba.AuctionService.service.CategoryService;
import com.seba.AuctionService.service.ProductService;
import com.seba.AuctionService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Controller
public class ProductCotroller {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;
    @Autowired
    AuctionService auctionService;



    @RequestMapping(value = "/product/addproduct", method = RequestMethod.GET)
    public ModelAndView addProduct(){
        ModelAndView modelAndView = new ModelAndView();
        ProductForm productForm = new ProductForm();
        List<CategoryDTO> categoryDTOSwithoutSubCategory = categoryService.findCategoriesDTOBySubCategoriesEmptyOrSubCategoriesNull();
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("categoryDTOS", categoryDTOSwithoutSubCategory);
        modelAndView.setViewName("product/addproduct");
        return modelAndView;
    }

    @RequestMapping(value = "/product/addproduct", method = RequestMethod.POST)
    public ModelAndView addProductPost(ProductForm productForm){
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user =  userService.findUserByEmail(authentication.getName());
        Product product = productForm.getProduct();
        try {
            product.setPhoto(productForm.getPictureDAO().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Calendar nowDate = Calendar.getInstance();
        product.setStartDate(new java.sql.Date(nowDate.getTimeInMillis()));
        nowDate.add(Calendar.DAY_OF_MONTH, productForm.getDaysDuration());
        product.setEndDate(new java.sql.Date(nowDate.getTimeInMillis()));
        product.setNumberOfVisits(0);
        product.setOwnerOfAuction(user);
        product.setCategory(categoryService.findByID(productForm.getSlectedCategoryDTO().getIdDTO()));
        if (user.getTypeUser() == TypeUser.PREMIUM) {
            product.setPromoted(true);
        } else {
            product.setPromoted(false);
        }

        productService.save(product);
        auctionService.save(product);
        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

}
