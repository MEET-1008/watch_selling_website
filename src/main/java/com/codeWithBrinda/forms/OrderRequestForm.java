package com.codeWithBrinda.forms;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderRequestForm {

    private String firstname ;

    private String lastname ;

    private String phone ;

    private String email ;

    private String address ;

    private String paymentMode;

}
