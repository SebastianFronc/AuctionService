package com.seba.AuctionService.Controller.Admin;

import com.seba.AuctionService.Entities.User.DTO.UserListDTO;
import com.seba.AuctionService.Entities.User.User;
import com.seba.AuctionService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class UserDetailViewController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/admin/userdetailview/{id}"}, method = RequestMethod.GET)
    public ModelAndView userDetailView(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findUserByID(id);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("admin/userdetailview");
        return modelAndView;
    }
}
