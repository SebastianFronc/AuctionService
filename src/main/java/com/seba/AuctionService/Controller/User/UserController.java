package com.seba.AuctionService.Controller.User;

import com.seba.AuctionService.Entities.User.DTO.LogoDAO;
import com.seba.AuctionService.Entities.User.User;
import com.seba.AuctionService.Service.UserService;
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
        LogoDAO logoDAO = new LogoDAO();
        modelAndView.addObject("user", user);
        modelAndView.addObject("logoDAO",logoDAO);

        modelAndView.setViewName("/user/edituser");
        return modelAndView;
    }

    @RequestMapping(value = "/user/updateuser", method = RequestMethod.POST)
    public ModelAndView updateUser(User editedUser, LogoDAO logoDAO){
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user =  userService.findUserByEmail(authentication.getName());
        user.setName(editedUser.getName());
        try {
            user.setLogo(logoDAO.getLogoDAO().getBytes());
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

