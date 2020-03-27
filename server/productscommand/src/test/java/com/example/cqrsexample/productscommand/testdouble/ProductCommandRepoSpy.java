package com.example.cqrsexample.productscommand.testdouble;

import com.example.cqrsexample.productscommand.entity.NewProduct;
import com.example.cqrsexample.productscommand.repo.ProductsCommandRepo;

public class ProductCommandRepoSpy implements ProductsCommandRepo {
    public NewProduct create_arg;
    public int create_returnValue = 0;

    @Override
    public int create(NewProduct product) {
        create_arg = product;
        return create_returnValue;
    }
}
