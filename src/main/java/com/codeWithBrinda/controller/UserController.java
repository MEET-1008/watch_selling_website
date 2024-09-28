package com.codeWithBrinda.controller;

import com.codeWithBrinda.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    ProductService productService;

    //    user Dashboard page
    @PostMapping("/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }


    //    user Dashboard page
    @GetMapping("/dashboard")
    public String userProfile() {
        return "user/dashboard";
    }


    @GetMapping("/profile")
    public String userDashboardget() {
        return "user/profile";
    }


    @PostMapping("/profile")
    public String userDashboardpost() {
        return "user/profile";
    }




}
