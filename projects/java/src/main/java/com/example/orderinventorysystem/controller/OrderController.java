package com.example.orderinventorysystem.controller;

import com.example.orderinventorysystem.commands.PlaceOrderCommand;
import com.example.orderinventorysystem.commands.ProcessOrderCommand;
import com.example.orderinventorysystem.commands.UpdateDeliveryStatusCommand;
import com.example.orderinventorysystem.events.OrderPlacedEvent;
import com.example.orderinventorysystem.events.OrderProcessedEvent;
import com.example.orderinventorysystem.events.DeliveryStatusUpdatedEvent;
import com.example.orderinventorysystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public ResponseEntity<OrderPlacedEvent> placeOrder(@RequestBody PlaceOrderCommand command) {
        OrderPlacedEvent event = orderService.placeOrder(command);
        return ResponseEntity.ok(event);
    }

    @PostMapping("/process/{orderId}")
    public ResponseEntity<OrderProcessedEvent> processOrder(@PathVariable String orderId) {
        ProcessOrderCommand command = new ProcessOrderCommand(UUID.fromString(orderId));
        OrderProcessedEvent event = orderService.processOrder(command);
        return ResponseEntity.ok(event);
    }

    @PostMapping("/update-delivery-status")
    public ResponseEntity<DeliveryStatusUpdatedEvent> updateDeliveryStatus(@RequestBody UpdateDeliveryStatusCommand command) {
        DeliveryStatusUpdatedEvent event = orderService.updateDeliveryStatus(command);
        return ResponseEntity.ok(event);
    }
}