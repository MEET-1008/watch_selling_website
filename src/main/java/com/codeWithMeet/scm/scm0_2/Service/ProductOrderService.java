package com.codeWithMeet.scm.scm0_2.Service;

import com.codeWithMeet.scm.scm0_2.entities.ProductOrder;
import com.codeWithMeet.scm.scm0_2.forms.OrderRequestForm;

import java.util.List;

public interface ProductOrderService {


    public void saveorder(int userId , OrderRequestForm orderRequestForm);

    List<ProductOrder>  getProductOrderByUser(int id );



}
