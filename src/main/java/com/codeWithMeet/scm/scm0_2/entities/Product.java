package com.codeWithMeet.scm.scm0_2.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String productImage;
    private String description;
    private Boolean favorite=false;

    @ManyToOne
    private User user;

}
