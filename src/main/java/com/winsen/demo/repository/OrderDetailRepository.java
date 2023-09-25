package com.winsen.demo.repository;

import com.winsen.demo.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailRepository {

    OrderDetail findById(String id);

    OrderDetail findByOrderNo(String orderNo);

    Integer insert(OrderDetail orderDetail);

}
