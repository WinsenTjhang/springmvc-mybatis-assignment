package com.winsen.demo.service;

import com.winsen.demo.DTO.*;
import com.winsen.demo.exception.*;
import com.winsen.demo.mapper.OrderMapper;
import com.winsen.demo.model.*;
import com.winsen.demo.repository.OrderRepository;
import com.winsen.demo.util.DateUtil;
import com.winsen.demo.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class OrderService {
    private UserService userService;
    private ProductService productService;
    private OrderRepository orderRepository;
    private OrderDetailService orderDetailService;
    private SysSeqService sysSeqService;
    private ValidationService validationService;

    @Autowired
    public OrderService(UserService userService,
                        ProductService productService,
                        OrderRepository orderRepository,
                        OrderDetailService orderDetailService,
                        SysSeqService sysSeqService,
                        ValidationService validationService) {
        this.userService = userService;
        this.productService = productService;
        this.orderRepository = orderRepository;
        this.orderDetailService = orderDetailService;
        this.sysSeqService = sysSeqService;
        this.validationService = validationService;
    }

    public CreateOrderResponse insert(CreateOrderRequest createOrderRequest) throws Exception {
        validationService.validateCreateOrderRequest(createOrderRequest);

        CreateOrderResponse createOrderResponse = new CreateOrderResponse();

        User user = userService.findById(createOrderRequest.getUserId());
        Product product = productService.findById(createOrderRequest.getItemId());

        String orderNumber = OrderUtil.generateOrderNumber();
        Long sysSeq = sysSeqService.getSeq(orderNumber);
        orderNumber = orderNumber + String.format("%04d", sysSeq);

        Order order = Order.builder()
                .id(UUID.randomUUID().toString().replace("-", ""))
                .bizDate(DateUtil.generateDate())
                .orderNo(orderNumber)
                .status(Status.PENDING_PAYMENT.getStatusShort())
                .remark(createOrderRequest.getRemark())
                .creator(user.getId())
                .createTime(System.currentTimeMillis())
                .build();
        orderRepository.insert(order);

        OrderDetail orderDetail = OrderDetail.builder()
                .id(UUID.randomUUID().toString().replace("-", ""))
                .orderNo(order.getOrderNo())
                .seq(sysSeq.intValue())
                .itemId(product.getId())
                .price(product.getPrice())
                .quantity(createOrderRequest.getQuantity())
                .unit(product.getUnit())
                .remark(order.getRemark())
                .build();
        orderDetailService.insert(orderDetail);

        createOrderResponse.setOrderId(order.getId());
        createOrderResponse.setBizDate(order.getBizDate());
        createOrderResponse.setOrderNo(order.getOrderNo());
        createOrderResponse.setStatus(order.getStatus());

        return createOrderResponse;
    }

    public UpdatePaymentToPaidResponse updatePaymentToPaid(String orderID) throws FailedUpdatePaymentException {
        validationService.validateOrderStatus(orderID);
        Integer updated = orderRepository.updatePaymentToPaid(orderID);

        if (updated == 0 ) {
            throw new FailedUpdatePaymentException("Failed payment update");
        }

        Order order = orderRepository.findById(orderID);
        System.out.println(order);
        return OrderMapper.mapOrderToUpdatePaymentToPaidResponse(order);
    }

    public UpdateOrderQuantityResponse updateOrderQuantity(UpdateOrderQuantityRequest request) throws Exception {
        validationService.validateOrderStatus(request.getOrderId());
        Integer updated = orderRepository.updateOrderQuantity(request.getOrderId(), request.getQuantity());

        if (updated == 0 ) {
            throw new FailedUpdateQuantityException("Failed update order quantity");
        }

        Order order = orderRepository.findById(request.getOrderId());

        return new UpdateOrderQuantityResponse(
                order.getId(),
                orderDetailService.findByOrderNo(order.getOrderNo()).getQuantity()
        );
    }



}
