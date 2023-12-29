package com.ordermanagement.interfaces;

import com.ordermanagement.application.OrderService;
import com.ordermanagement.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.createOrder(orderRequest.get메뉴(), orderRequest.get배송주소());
        OrderResponse orderResponse = new OrderResponse(order.get주문번호(), order.get주문상태());
        return ResponseEntity.ok(orderResponse);
    }
}