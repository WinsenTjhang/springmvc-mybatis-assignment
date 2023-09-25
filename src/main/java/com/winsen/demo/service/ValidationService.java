package com.winsen.demo.service;

import com.winsen.demo.DTO.CreateOrderRequest;
import com.winsen.demo.exception.InvalidOrderRequestException;
import com.winsen.demo.exception.InvalidProductException;
import com.winsen.demo.exception.InvalidUserException;
import com.winsen.demo.model.Order;
import com.winsen.demo.model.Product;
import com.winsen.demo.model.User;
import com.winsen.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ValidationService {
    private UserService userService;
    private ProductService productService;
    private OrderRepository orderRepository;


    @Autowired
    public ValidationService(UserService userService,
                        ProductService productService,
                        OrderRepository orderRepository) {
        this.userService = userService;
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    public void validateCreateOrderRequest(CreateOrderRequest createOrderRequest) throws Exception {
        User user = userService.findById(createOrderRequest.getUserId());
        Product product = productService.findById(createOrderRequest.getItemId());

        if (user == null) {
            throw new InvalidUserException("User not found");
        }

        if (user.getDeleted() == 1 || user.getStatus() != 1) {
            throw new InvalidUserException("User is deleted or on \"Frozen\" status");
        }

        if (product == null) {
            throw new InvalidProductException("Product not found");
        }

        if (product.getDeleted() == 1) {
            throw new InvalidProductException("Deleted product");
        }

        if (!Objects.equals(product.getPrice(), createOrderRequest.getPrice())) {
            throw new InvalidOrderRequestException("Inconsistent price");
        }

        if (createOrderRequest.getQuantity() <= 0) {
            throw new InvalidOrderRequestException("Product quantity should be more than 0");
        }
    }

    public void validateOrderStatus(String id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new InvalidOrderRequestException("Invalid order");
        }

        if (order.getStatus() != 1) {
            throw new InvalidOrderRequestException("Order status is not pending");
        }
    }

}
