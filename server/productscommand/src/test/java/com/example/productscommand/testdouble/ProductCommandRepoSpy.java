package com.example.productscommand.testdouble;

import com.example.productscommand.entity.NewProduct;
import com.example.productscommand.repo.ProductsCommandRepo;

public class ProductCommandRepoSpy implements ProductsCommandRepo {
    public NewProduct create_arg;
    public int create_returnValue = 0;

    @Override
    public int create(NewProduct product) {
        create_arg = product;
        return create_returnValue;
    }
}
