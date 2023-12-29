package com.example.orderinventorysystem.service;

import com.example.orderinventorysystem.commands.PlaceOrderCommand;
import com.example.orderinventorysystem.commands.ProcessOrderCommand;
import com.example.orderinventorysystem.commands.UpdateDeliveryStatusCommand;
import com.example.orderinventorysystem.domain.Order;
import com.example.orderinventorysystem.events.OrderPlacedEvent;
import com.example.orderinventorysystem.events.OrderProcessedEvent;
import com.example.orderinventorysystem.events.DeliveryStatusUpdatedEvent;
import com.example.orderinventorysystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public OrderPlacedEvent placeOrder(PlaceOrderCommand command) {
        // Business logic to place an order
        Order order = new Order();
        order.setProductId(command.getProductId());
        order.setQuantity(command.getQuantity());
        order.setStatus("PLACED");
        order = orderRepository.save(order);

        return new OrderPlacedEvent(order.getOrderId(), order.getProductId(), order.getQuantity());
    }

    @Transactional
    public OrderProcessedEvent processOrder(ProcessOrderCommand command) {
        // Business logic to process an order
        Order order = orderRepository.findById(command.getOrderId()).orElseThrow();
        order.setStatus("PROCESSED");
        order = orderRepository.save(order);

        return new OrderProcessedEvent(order.getOrderId(), order.getStatus());
    }

    @Transactional
    public DeliveryStatusUpdatedEvent updateDeliveryStatus(UpdateDeliveryStatusCommand command) {
        // Business logic to update delivery status
        Order order = orderRepository.findById(command.getOrderId()).orElseThrow();
        order.setStatus(command.getStatus());
        order = orderRepository.save(order);

        return new DeliveryStatusUpdatedEvent(order.getOrderId(), order.getStatus());
    }
}