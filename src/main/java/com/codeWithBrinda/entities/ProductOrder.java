package com.codeWithBrinda.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String orderId ;

    private String orderDate ;

    @ManyToOne
    private Product product ;

    private double price ;

    private int quantity ;

    @OneToOne(cascade = CascadeType.ALL)
    private orderAddress orderAddress;

    @ManyToOne
    private  User user;

    private String status;

    private String paymentMode;

    private String razorPayOrderId;

}
