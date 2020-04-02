package com.example.productsquery.dataprojector.repo;

import com.example.productsquery.dto.ProductQueryDto;

public interface ProductsCommandRepo {
    void create(ProductQueryDto dto);
}
