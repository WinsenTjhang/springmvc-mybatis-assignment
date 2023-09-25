package com.winsen.demo.mapper;

import com.winsen.demo.DTO.UpdatePaymentToPaidResponse;
import com.winsen.demo.model.Order;

public class OrderMapper {

    public static UpdatePaymentToPaidResponse mapOrderToUpdatePaymentToPaidResponse(Order order) {
        return UpdatePaymentToPaidResponse.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .build();
    }
}
