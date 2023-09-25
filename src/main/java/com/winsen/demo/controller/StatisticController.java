package com.winsen.demo.controller;

import com.winsen.demo.model.ProductSales;
import com.winsen.demo.repository.UserRepository;
import com.winsen.demo.service.OrderService;
import com.winsen.demo.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticController {
    private UserRepository userRepository;
    private OrderService orderService;
    private StatisticService statisticService;

    @Autowired
    public StatisticController(UserRepository userRepository, OrderService orderService, StatisticService statisticService) {
        this.userRepository = userRepository;
        this.orderService = orderService;
        this.statisticService = statisticService;
    }

    @GetMapping("/product-sales")
    public ResponseEntity<List<ProductSales>> getProducts() {
        List<ProductSales> products = statisticService.getProductSalesSortedByQuantity();
        return ResponseEntity.ok(products);
    }
}
