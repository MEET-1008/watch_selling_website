package com.codeWithBrinda.Service;

import com.codeWithBrinda.entities.ProductOrder;
import com.codeWithBrinda.forms.OrderRequestForm;

import java.util.List;

public interface ProductOrderService {


    public void saveorder(int userId , OrderRequestForm orderRequestForm);

    List<ProductOrder>  getAllProductOrder( );





}
