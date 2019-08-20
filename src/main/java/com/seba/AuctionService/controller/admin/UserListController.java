package com.seba.AuctionService.controller.admin;

import com.seba.AuctionService.entities.user.dto.UserListDTO;
import com.seba.AuctionService.service.UserDTOService;
import com.seba.AuctionService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserListController {

    @Autowired
    UserDTOService userDTOService;

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/admin/userslist"}, method = RequestMethod.GET)
    public ModelAndView userList(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserListDTO> userListDTOS = userDTOService.findAllUserListDTO();
        modelAndView.addObject("userListDTOS",userListDTOS);
        modelAndView.setViewName("admin/userslist");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/switchactiv/{id}")
    public RedirectView switchActiv(@PathVariable long id){
        userService.switchActiv(id);
        return new RedirectView("/admin/userslist");
    }

    @RequestMapping(value = "/admin/switchrole/{id}")
    public RedirectView switchRole(@PathVariable long id){
        userService.switchRole(id);
        return new RedirectView("/admin/userslist");
    }
}
