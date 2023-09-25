package com.winsen.demo.service;

import com.winsen.demo.model.OrderDetail;
import com.winsen.demo.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public OrderDetail findById(String id) {
        return orderDetailRepository.findById(id);
    }

    public Integer insert(OrderDetail orderDetail) {
        return orderDetailRepository.insert(orderDetail);
    }

    public OrderDetail findByOrderNo(String orderNo) {
        return orderDetailRepository.findByOrderNo(orderNo);
    }

}
