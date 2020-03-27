package com.example.productscommand.repo;

import com.example.productscommand.entity.NewProduct;

public interface ProductsCommandRepo {
    int create(NewProduct product);
}
