package com.example.cqrsexample.productsquery.query;

import java.util.UUID;

public class FindOutOfStockProducts implements Query {
    private UUID id;

    public FindOutOfStockProducts() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return null;
    }
}
