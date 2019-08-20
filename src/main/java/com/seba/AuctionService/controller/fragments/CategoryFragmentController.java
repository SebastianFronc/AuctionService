package com.seba.AuctionService.controller.fragments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryFragmentController {


    @GetMapping("/category")
    public String getCategory() {
        return "categoryFragment.html";
    }


}
