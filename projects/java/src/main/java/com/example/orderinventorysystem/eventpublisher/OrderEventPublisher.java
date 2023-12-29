package com.example.orderinventorysystem.eventpublisher;

import com.example.orderinventorysystem.events.OrderPlacedEvent;
import com.example.orderinventorysystem.events.OrderProcessedEvent;
import com.example.orderinventorysystem.events.DeliveryStatusUpdatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class OrderEventPublisher {

    private final Source source;

    @Autowired
    public OrderEventPublisher(Source source) {
        this.source = source;
    }

    public void publishOrderPlacedEvent(OrderPlacedEvent event) {
        source.output().send(MessageBuilder.withPayload(event).build());
    }

    public void publishOrderProcessedEvent(OrderProcessedEvent event) {
        source.output().send(MessageBuilder.withPayload(event).build());
    }

    public void publishDeliveryStatusUpdatedEvent(DeliveryStatusUpdatedEvent event) {
        source.output().send(MessageBuilder.withPayload(event).build());
    }
}