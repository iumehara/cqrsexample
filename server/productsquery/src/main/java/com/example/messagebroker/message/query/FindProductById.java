package com.example.messagebroker.message.query;

import com.example.messagebroker.QueueName;
import com.example.messagebroker.message.Query;

import java.util.UUID;

import static com.example.messagebroker.QueueName.FIND_PRODUCT_BY_ID;

public class FindProductById implements Query {
    private UUID id;
    private int productId;

    public FindProductById(int productId) {
        this.id = UUID.randomUUID();
        this.productId = productId;
    }

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public QueueName getQueueName() {
        return FIND_PRODUCT_BY_ID;
    }

    public int getProductId() {
        return productId;
    }
}
