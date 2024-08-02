package com.codeWithMeet.scm.scm0_2.controller;

import com.codeWithMeet.scm.scm0_2.Repo.UserRepo;
import com.codeWithMeet.scm.scm0_2.Service.ProductOrderService;
import com.codeWithMeet.scm.scm0_2.Service.UserService;
import com.codeWithMeet.scm.scm0_2.entities.Cart;
import com.codeWithMeet.scm.scm0_2.entities.User;
import com.codeWithMeet.scm.scm0_2.helper.Helper;
import com.codeWithMeet.scm.scm0_2.helper.MessageHelper;
import com.codeWithMeet.scm.scm0_2.helper.MessageType;
import com.codeWithMeet.scm.scm0_2.Repo.CartRepo;
import com.codeWithMeet.scm.scm0_2.Repo.ProductOrderRepo;
import com.codeWithMeet.scm.scm0_2.Service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user/product")
public class CartController {

    @Autowired
    CartService cartService ;

    @Autowired
    UserService userService ;

    @Autowired
    ProductOrderService productOrderService;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private ProductOrderRepo productOrderRepo;

    @GetMapping("/addCart")
    public String addCart(@RequestParam int pid , @RequestParam int uid , Model model, HttpSession session){

        Cart saveCart = cartService.saveCart(pid, uid);

        if(ObjectUtils.isEmpty(saveCart)){
            session.setAttribute("message", MessageHelper.builder().content("user already signup...! ").type(MessageType.red).build());
        }

        System.out.println("pid is :- " + pid + " uid is :- " + uid);

        return "redirect:all";
    }


    @GetMapping("/loadCard")
    public String loadCardPage(Authentication authentication , Model model){


        String email = Helper.getEmailOfLoggedInUser(authentication);
        User user = userService.getUserByEmail(email);

        List<Cart> carts = cartService.getCartByUser(user.getUserid());

        model.addAttribute("carts", carts);
        if (carts.size() > 0 ) {
            model.addAttribute("totalorderAmount", (carts.get(carts.size() - 1)).getTotalOrderAmount());
        }

        return "user/cart";
    }


    @GetMapping("/cartQunUpdate")
    public String cartQunUpdate(@RequestParam String sy , @RequestParam int  cid , Model model){

        cartService.updatequantity(sy , cid );

        return "redirect:loadCard";
    }



}
