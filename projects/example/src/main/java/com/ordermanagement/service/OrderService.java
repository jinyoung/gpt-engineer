package com.ordermanagement.service;

import com.ordermanagement.domain.Order;
import com.ordermanagement.domain.OrderStatus;
import com.ordermanagement.dto.CreateOrderRequest;
import com.ordermanagement.dto.OrderCreatedEvent;
import com.ordermanagement.messaging.OrderEventPublisher;
import com.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventPublisher orderEventPublisher;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderEventPublisher orderEventPublisher) {
        this.orderRepository = orderRepository;
        this.orderEventPublisher = orderEventPublisher;
    }

    public OrderCreatedEvent createOrder(CreateOrderRequest request) {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.ORDERED);
        order = orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent(order.getOrderNumber(), order.getOrderStatus().name());
        orderEventPublisher.publishOrderCreatedEvent(event);

        return event;
    }
}