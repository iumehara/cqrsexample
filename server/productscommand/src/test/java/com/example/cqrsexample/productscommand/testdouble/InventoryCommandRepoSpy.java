package com.example.cqrsexample.productscommand.testdouble;

import com.example.cqrsexample.productscommand.entity.NewInventory;
import com.example.cqrsexample.productscommand.repo.InventoryCommandRepo;

public class InventoryCommandRepoSpy implements InventoryCommandRepo {
    public NewInventory create_arg;

    @Override
    public int create(NewInventory inventory) {
        this.create_arg = inventory;
        return 0;
    }
}
