package com.codeWithMeet.scm.scm0_2.Service;

import com.codeWithMeet.scm.scm0_2.entities.Product;
import com.codeWithMeet.scm.scm0_2.entities.User;

import java.util.List;

public interface ProductService {


    Product save(Product product);

    Product getContactById(int id);

    List<Product> getAllProduct();

    void deleteProduct(int id);

    Product updateProduct(Product product, int id);

    List<Product> getProductByUserId(int UserId);


    List<Product> getByUser(User user);
}
