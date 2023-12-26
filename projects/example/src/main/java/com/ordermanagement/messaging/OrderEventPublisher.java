package com.ordermanagement.messaging;

import com.ordermanagement.dto.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class OrderEventPublisher {

    private final StreamBridge streamBridge;

    @Autowired
    public OrderEventPublisher(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void publishOrderCreatedEvent(OrderCreatedEvent event) {
        streamBridge.send("orderCreatedEvent-out-0", event);
    }
}