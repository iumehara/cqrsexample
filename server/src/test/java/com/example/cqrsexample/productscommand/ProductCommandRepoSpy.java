package com.example.cqrsexample.productscommand;

import com.example.cqrsexample.productscommand.entity.NewProduct;
import com.example.cqrsexample.productscommand.repo.ProductsCommandRepo;

public class ProductCommandRepoSpy implements ProductsCommandRepo {
    NewProduct create_arg;
    int create_returnValue = 0;

    @Override
    public int create(NewProduct product) {
        create_arg = product;
        return create_returnValue;
    }
}
