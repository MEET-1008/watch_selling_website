package com.codeWithBrinda.controller;

import com.codeWithBrinda.Service.ProductOrderService;
import com.codeWithBrinda.entities.ProductOrder;
import com.codeWithBrinda.entities.User;
import com.codeWithBrinda.Service.CartService;
import com.codeWithBrinda.Service.UserService;
import com.codeWithBrinda.helper.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@ControllerAdvice
public class RootController {


    @Autowired
    private UserService userService;

    @Autowired
    CartService cartService;
    @Autowired
    ProductOrderService productOrderService;

    @ModelAttribute
    public void addLoggedInUserInformation(Model model, Authentication authentication) {
        System.out.println("meet");
        if (authentication == null) {
            System.out.println("authentication is null");
            return;
        }

        System.out.println("Adding logged in user information to the model");
        String email = Helper.getEmailOfLoggedInUser(authentication);
        System.out.println("User logged in: "+  "{ " +email + " }");
        User user = userService.getUserByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("cartCount", cartService.getcountCart(user.getUserid()));
        List<ProductOrder> allProductOrder = productOrderService.getAllProductOrder();
        model.addAttribute("orderCount", allProductOrder.size());

    }
}
