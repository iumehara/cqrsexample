package com.example.productsquery.dataprojector.repo;

import com.example.productsquery.dto.ProductQueryDto;

public class SpyProductsCommandRepo implements ProductsCommandRepo {
    private ProductQueryDto create_args;

    @Override
    public void create(ProductQueryDto dto) {
        create_args = dto;
    }

    public ProductQueryDto getCreate_args() {
        return create_args;
    }
}
