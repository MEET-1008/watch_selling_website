package com.codeWithMeet.scm.scm0_2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
