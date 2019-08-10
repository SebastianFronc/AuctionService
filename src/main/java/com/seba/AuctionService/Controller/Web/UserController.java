package com.seba.AuctionService.Controller.Web;

import com.seba.AuctionService.Entities.User.RoleUser;
import com.seba.AuctionService.Entities.User.StatusUser;
import com.seba.AuctionService.Entities.User.TypeUser;
import com.seba.AuctionService.Entities.User.User;
import com.seba.AuctionService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public RedirectView addNewUser(@Valid User user, BindingResult bindingResult){

        User userExists = userService.findUserByEmail(user.getEmail());

        if (userExists != null) {
            bindingResult.rejectValue("email", "error.user", "There is already a user registered with the email provided");
        } if(bindingResult.hasErrors()) {
            return new RedirectView("/registration");
        } else {
            user.setTypeUser(TypeUser.NORMAL);
            user.setStatusUser(StatusUser.ACTIV);
            user.setRoleUser(RoleUser.USER);
            userService.save(user);
            return new RedirectView("/");

        }
    }

}
