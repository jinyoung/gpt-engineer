package com.example.orderinventorysystem.eventpublisher;

import com.example.orderinventorysystem.events.InventoryManagedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class InventoryEventPublisher {

    private final Source source;

    @Autowired
    public InventoryEventPublisher(Source source) {
        this.source = source;
    }

    public void publishInventoryManagedEvent(InventoryManagedEvent event) {
        source.output().send(MessageBuilder.withPayload(event).build());
    }
}