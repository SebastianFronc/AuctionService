package com.seba.AuctionService.controller.auction;

import com.seba.AuctionService.entities.auction.Auction;
import com.seba.AuctionService.entities.product.Category;
import com.seba.AuctionService.service.AuctionService;
import com.seba.AuctionService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
public class AuctionController {

    @Autowired
    AuctionService auctionService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "auction/auctionlist", method = RequestMethod.GET)
    public ModelAndView listOfCategory(){
        ModelAndView modelAndView = new ModelAndView();
        Category mainCategory = categoryService.findCategoryByParentNull();
        Set<Category> mainSubCategories = mainCategory.getSubCategories();
        modelAndView.addObject("subMainCategories", mainSubCategories);
        List<Auction> activAuction = auctionService.findActivAuction();
        modelAndView.addObject("activAuction", activAuction);
        modelAndView.setViewName("auction/auctionlist");
        return modelAndView;
    }


}
