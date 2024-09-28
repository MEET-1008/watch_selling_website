package com.codeWithBrinda.controller;

import com.codeWithBrinda.Service.ProductService;
import com.codeWithBrinda.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user/product")
public class ProductConroller {

    @Autowired
    ProductService productService;



    @GetMapping("/all")
    public String viewAllProduct(
            Model model,
            Authentication authentication) {


        List<Product> products = productService.getAllProduct();

        System.out.println(products.toString());

        model.addAttribute("product", products);


        return "user/allproduct";
    }






}
