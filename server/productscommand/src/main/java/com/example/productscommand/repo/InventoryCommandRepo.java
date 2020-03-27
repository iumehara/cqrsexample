package com.example.productscommand.repo;

import com.example.productscommand.entity.NewInventory;

public interface InventoryCommandRepo {
    int create(NewInventory product);
}
