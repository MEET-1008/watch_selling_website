package com.codeWithMeet.scm.scm0_2.controller;

import com.codeWithMeet.scm.scm0_2.entities.User;
import com.codeWithMeet.scm.scm0_2.Service.CartService;
import com.codeWithMeet.scm.scm0_2.Service.UserService;
import com.codeWithMeet.scm.scm0_2.helper.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


@ControllerAdvice
public class RootController {


    @Autowired
    private UserService userService;

    @Autowired
    CartService cartService;

    @ModelAttribute
    public void addLoggedInUserInformation(Model model, Authentication authentication) {
        if (authentication == null) {
            return;
        }
        System.out.println("Adding logged in user information to the model");
        String email = Helper.getEmailOfLoggedInUser(authentication);
        System.out.println("User logged in: "+  "{ " +email + " }");
        User user = userService.getUserByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("cartCount", cartService.getcountCart(user.getUserid()));



    }
}
