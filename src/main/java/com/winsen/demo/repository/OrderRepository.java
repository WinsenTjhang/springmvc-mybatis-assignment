package com.winsen.demo.repository;

import com.winsen.demo.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderRepository {

    Order findById(String id);

    Integer updatePaymentToPaid(@Param("id") String id);

    Integer insert(Order order);

    Integer updateOrderQuantity(String id, Long quantity);
}
