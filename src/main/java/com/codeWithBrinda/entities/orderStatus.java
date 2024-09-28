package com.codeWithBrinda.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum orderStatus {

    IN_PROGRESS(1," in progress") ,
    ORDER_RECIVED(2,"order recived") ,
    ORDER_COMLITED(3," order complited") ;

    private int id;
    private String name;

}
