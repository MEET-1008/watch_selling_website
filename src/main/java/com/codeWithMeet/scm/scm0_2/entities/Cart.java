package com.codeWithMeet.scm.scm0_2.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;


    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private int quantity;

    @Transient
    private double totalPrice;

    @Transient
    private double totalOrderAmount;





}
