package com.example.cqrsexample.productscommand.repo;

import com.example.cqrsexample.productscommand.entity.NewProduct;

public interface ProductsCommandRepo {
    int create(NewProduct product);
}
