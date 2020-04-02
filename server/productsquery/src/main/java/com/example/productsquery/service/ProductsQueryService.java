package com.example.productsquery.service;

import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;

import java.util.List;

public interface ProductsQueryService {
    ProductQueryDto findProductById(int id);

    List<ProductInventoryQueryDto> findOutOfStockProducts();
}
