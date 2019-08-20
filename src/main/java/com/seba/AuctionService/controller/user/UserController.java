package com.seba.AuctionService.controller.user;

import com.seba.AuctionService.entities.dao.PictureDAO;
import com.seba.AuctionService.entities.user.User;
import com.seba.AuctionService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/user/home"}, method = RequestMethod.GET)
    public ModelAndView homeUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }


    @RequestMapping(value = "/user/edituser", method = RequestMethod.GET)
    public ModelAndView editUser(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user =  userService.findUserByEmail(authentication.getName());
        PictureDAO pictureDAO = new PictureDAO();
        modelAndView.addObject("user", user);
        modelAndView.addObject("pictureDAO", pictureDAO);

        modelAndView.setViewName("/user/edituser");
        return modelAndView;
    }

    @RequestMapping(value = "/user/updateuser", method = RequestMethod.POST)
    public ModelAndView updateUser(User editedUser, PictureDAO pictureDAO){
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user =  userService.findUserByEmail(authentication.getName());
        user.setName(editedUser.getName());
        try {
            user.setLogo(pictureDAO.getPictureDAO().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.getAdress().setProvince(editedUser.getAdress().getProvince());
        user.getAdress().setCity(editedUser.getAdress().getCity());
        user.getAdress().setZipCode(editedUser.getAdress().getZipCode());
        user.getAdress().setStreet(editedUser.getAdress().getStreet());
        user.getAdress().setHomeNumber(editedUser.getAdress().getHomeNumber());
        userService.update(user);
        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }




}

