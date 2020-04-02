package com.example.messagebroker.message.query;

import com.example.messagebroker.QueueName;
import com.example.messagebroker.message.Query;

import java.util.UUID;

import static com.example.messagebroker.QueueName.FIND_OUT_OF_STOCK_PRODUCTS;

public class FindOutOfStockProducts implements Query {
    private UUID id;

    public FindOutOfStockProducts() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public QueueName getQueueName() {
        return FIND_OUT_OF_STOCK_PRODUCTS;
    }
}
