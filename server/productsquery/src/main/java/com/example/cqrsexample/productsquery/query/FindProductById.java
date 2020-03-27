package com.example.cqrsexample.productsquery.query;

import java.util.UUID;

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

    public int getProductId() {
        return productId;
    }
}
