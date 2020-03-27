package com.example.productsquery.repo;


import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;

import java.util.List;

public interface ProductsQueryRepo {
    ProductQueryDto findById(int productId);

    List<ProductInventoryQueryDto> findOutOfStockProducts();
}
