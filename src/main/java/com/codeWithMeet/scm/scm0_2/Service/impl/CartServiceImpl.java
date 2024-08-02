package com.codeWithMeet.scm.scm0_2.Service.impl;

import com.codeWithMeet.scm.scm0_2.Repo.CartRepo;
import com.codeWithMeet.scm.scm0_2.Repo.ProductRepo;
import com.codeWithMeet.scm.scm0_2.Repo.UserRepo;
import com.codeWithMeet.scm.scm0_2.Service.CartService;
import com.codeWithMeet.scm.scm0_2.entities.Cart;
import com.codeWithMeet.scm.scm0_2.entities.Product;
import com.codeWithMeet.scm.scm0_2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CartRepo cartRepo;


    @Override
    public Cart saveCart(int productId, int userId) {

        User user = userRepo.findById(userId).get();
        Product product = productRepo.findById(productId).get();

        Cart cartStatus = cartRepo.findByProductIdAndUserUserid(productId, userId);

        Cart cart = null;

        if (ObjectUtils.isEmpty(cartStatus)) {
            cart = new Cart();
            cart.setUser(user);
            cart.setProduct(product);
            cart.setQuantity(1);
            cart.setTotalPrice(1 * product.getPrice());

        } else {
            cart = cartStatus;
            cart.setQuantity(cart.getQuantity() + 1);
            cart.setTotalPrice(cart.getQuantity() * cart.getProduct().getPrice());
        }

        return cartRepo.save(cart);

    }

    @Override
    public List<Cart> getCartByUser(int userId) {
        List<Cart> carts = cartRepo.findByUserUserid(userId);

        Double totalOrderAmount = 0.0;

        ArrayList<Cart> carts1 = new ArrayList<>();
        for (Cart c : carts) {
            Double totalPrice = (c.getProduct().getPrice() * c.getQuantity());
            c.setTotalPrice(totalPrice);
            totalOrderAmount += totalPrice;
            c.setTotalOrderAmount(totalOrderAmount);
            carts1.add(c);
        }


        return carts;
    }

    @Override
    public int getcountCart(int UserId) {
        return cartRepo.countByUserUserid(UserId);
    }

    @Override
    public void updatequantity(String sy, int cid) {

        Cart cart = cartRepo.findById(cid).get();
        int updatequantity1;

        if (sy.equalsIgnoreCase("de")) {
            updatequantity1 = cart.getQuantity() - 1;
            if (updatequantity1 <= 0) {
                cartRepo.delete(cart);
            }else {

                cart.setQuantity(updatequantity1);
                cartRepo.save(cart);
            }
        } else {
            updatequantity1 = cart.getQuantity() + 1;
            cart.setQuantity(updatequantity1);
            cartRepo.save(cart);
        }

    }

    @Override
    public void DeleteCart(int uid) {
        cartRepo.deleteByUserUserid(uid);
    }
}