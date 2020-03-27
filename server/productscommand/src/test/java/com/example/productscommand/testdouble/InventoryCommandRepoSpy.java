package com.example.productscommand.testdouble;

import com.example.productscommand.entity.NewInventory;
import com.example.productscommand.repo.InventoryCommandRepo;

public class InventoryCommandRepoSpy implements InventoryCommandRepo {
    public NewInventory create_arg;

    @Override
    public int create(NewInventory inventory) {
        this.create_arg = inventory;
        return 0;
    }
}
