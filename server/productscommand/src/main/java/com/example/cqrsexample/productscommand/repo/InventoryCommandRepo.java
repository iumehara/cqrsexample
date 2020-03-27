package com.example.cqrsexample.productscommand.repo;

import com.example.cqrsexample.productscommand.entity.NewInventory;

public interface InventoryCommandRepo {
    int create(NewInventory product);
}
