package com.codeWithBrinda.Service.impl;

import com.codeWithBrinda.Service.ProductOrderService;
import com.codeWithBrinda.entities.Cart;
import com.codeWithBrinda.Repo.CartRepo;
import com.codeWithBrinda.Repo.ProductOrderRepo;
import com.codeWithBrinda.entities.ProductOrder;
import com.codeWithBrinda.entities.orderAddress;
import com.codeWithBrinda.entities.orderStatus;
import com.codeWithBrinda.forms.OrderRequestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {


    @Autowired
    ProductOrderRepo productOrderRepo;

    @Autowired
    CartRepo cartRepo;


    @Override
    public void saveorder(int userId, OrderRequestForm orderRequestForm) {


        List<Cart> carts = cartRepo.findByUserUserid(userId);

        String orderid = UUID.randomUUID().toString();

        for (Cart cart : carts) {
            ProductOrder order = new ProductOrder();
            order.setOrderId(orderid);
            LocalDateTime ldt = LocalDateTime.now();
            order.setOrderDate(DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt) );
            order.setProduct(cart.getProduct());
            order.setPrice(cart.getProduct().getPrice());
            order.setQuantity(cart.getQuantity());
            order.setUser(cart.getUser());
            order.setStatus(orderStatus.IN_PROGRESS.getName());
            order.setPaymentMode(orderRequestForm.getPaymentMode());
            orderAddress address = new orderAddress();
            address.setFirstname(orderRequestForm.getFirstname());
            address.setLastname(orderRequestForm.getLastname());
            address.setEmail(orderRequestForm.getEmail());
            address.setPhone(orderRequestForm.getPhone());
            address.setAddress(orderRequestForm.getAddress());
            order.setOrderAddress(address);
            productOrderRepo.save(order);
        }

    }

    @Override
    public List<ProductOrder> getAllProductOrder() {

    return     productOrderRepo.findAll();

    }



}
