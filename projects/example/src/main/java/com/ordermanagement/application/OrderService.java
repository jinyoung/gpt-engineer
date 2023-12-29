package com.ordermanagement.application;

import com.ordermanagement.domain.Order;
import com.ordermanagement.domain.OrderRepository;
import com.ordermanagement.infrastructure.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final MessageChannel output;

    @Autowired
    public OrderService(OrderRepository orderRepository, MessageChannel output) {
        this.orderRepository = orderRepository;
        this.output = output;
    }

    public Order createOrder(String 메뉴, String 배송주소) {
        Order order = new Order(메뉴, 배송주소);
        order = orderRepository.save(order);
        publishOrderCreatedEvent(order);
        return order;
    }

    private void publishOrderCreatedEvent(Order order) {
        OrderCreatedEvent event = new OrderCreatedEvent(order.get주문번호(), order.get주문상태());
        output.send(MessageBuilder.withPayload(event).build());
    }
}