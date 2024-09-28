package com.codeWithBrinda.Service;

import com.codeWithBrinda.entities.Cart;

import java.util.List;

public interface CartService {

    public Cart saveCart(int productId, int userId);

    public List<Cart> getCartByUser(int userId);

    public int  getcountCart (int UserId);

    void updatequantity(String sy, int cid);

    void DeleteCart(int uid);
}
