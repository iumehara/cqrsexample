package com.example.messagebroker.message.event;

import com.example.messagebroker.message.Event;
import com.example.messagebroker.QueueName;

import java.util.UUID;

import static com.example.messagebroker.QueueName.PRODUCT_RATED;

public class ProductRated implements Event {
    private UUID id;

    public ProductRated() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public QueueName getQueueName() {
        return PRODUCT_RATED;
    }
}
