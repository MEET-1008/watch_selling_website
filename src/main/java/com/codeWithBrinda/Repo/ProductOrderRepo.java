package com.codeWithBrinda.Repo;

import com.codeWithBrinda.entities.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepo extends JpaRepository<ProductOrder, Integer> {

    List<ProductOrder> findByUserUserid(int id);


    @Query("SELECT c FROM ProductOrder c WHERE c.user.userid = :UserId AND c.orderId = :orderId")
    List<ProductOrder> findByUserId (@Param("UserId") int userId , @Param("orderId") String orderId);


}
