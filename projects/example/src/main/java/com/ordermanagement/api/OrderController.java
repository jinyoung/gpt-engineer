package com.ordermanagement.api;

import com.ordermanagement.dto.CreateOrderRequest;
import com.ordermanagement.dto.OrderCreatedEvent;
import com.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<OrderCreatedEvent> createOrder(@RequestBody CreateOrderRequest request) {
        OrderCreatedEvent event = orderService.createOrder(request);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }
}