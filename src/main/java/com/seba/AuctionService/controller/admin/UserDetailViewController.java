package com.seba.AuctionService.controller.admin;

import com.seba.AuctionService.entities.user.User;
import com.seba.AuctionService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Base64;


@Controller

public class UserDetailViewController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/admin/userdetailview/{id}"}, method = RequestMethod.GET)
    public ModelAndView userDetailView(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserByID(id);
        modelAndView.addObject("user",user);
        String logoEncoded = Base64.getEncoder().encodeToString(user.getLogo());
        modelAndView.addObject("logoEncoded", logoEncoded);
        modelAndView.setViewName("admin/userdetailview");
        return modelAndView;
    }
}
