package com.winsen.demo.controller;

import com.winsen.demo.DTO.*;
import com.winsen.demo.exception.FailedUpdatePaymentException;
import com.winsen.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<CreateOrderResponse> add(@RequestBody CreateOrderRequest createOrderRequest) throws Exception {
        CreateOrderResponse createOrderResponse = orderService.insert(createOrderRequest);
        return ResponseEntity.ok(createOrderResponse);
    }

    @PutMapping("/orders/paid")
    public ResponseEntity<UpdatePaymentToPaidResponse> updatePaymentToPaid(@RequestBody UpdatePaymentToPaidRequest updatePaymentToPaidRequest) throws FailedUpdatePaymentException {
        UpdatePaymentToPaidResponse updatePaymentToPaidResponse = orderService.updatePaymentToPaid(updatePaymentToPaidRequest.getOrderId());
        return ResponseEntity.ok(updatePaymentToPaidResponse);
    }

    @PutMapping("/orders/quantity")
    public ResponseEntity<UpdateOrderQuantityResponse> changeProductQuantity(@RequestBody UpdateOrderQuantityRequest updateOrderQuantityRequest) throws Exception {
        UpdateOrderQuantityResponse updateOrderQuantityResponse = orderService.updateOrderQuantity(updateOrderQuantityRequest);
        return ResponseEntity.ok(updateOrderQuantityResponse);

    }

}
