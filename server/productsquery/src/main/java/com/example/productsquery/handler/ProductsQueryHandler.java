package com.example.productsquery.handler;

import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;
import com.example.messagebroker.message.query.FindOutOfStockProducts;
import com.example.messagebroker.message.query.FindProductById;

import java.util.List;

public interface ProductsQueryHandler {
    ProductQueryDto handle(FindProductById query);

    List<ProductInventoryQueryDto> handle(FindOutOfStockProducts query);
}
