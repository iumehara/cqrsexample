package com.example.cqrsexample.productsquery.repo;


import com.example.cqrsexample.productsquery.dto.ProductInventoryQueryDto;
import com.example.cqrsexample.productsquery.dto.ProductQueryDto;

import java.util.List;

public interface ProductsQueryRepo {
    ProductQueryDto findById(int productId);

    List<ProductInventoryQueryDto> findOutOfStockProducts();
}
