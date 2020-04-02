package com.example.productsquery.handler;

import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;
import com.example.messagebroker.message.query.FindOutOfStockProducts;
import com.example.messagebroker.message.query.FindProductById;
import com.example.productsquery.repo.ProductsQueryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProductsQueryHandler implements ProductsQueryHandler {
    private ProductsQueryRepo repo;

    public DefaultProductsQueryHandler(ProductsQueryRepo repo) {
        this.repo = repo;
    }

    public ProductQueryDto handle(FindProductById query) {
        return repo.findById(query.getProductId());
    }

    public List<ProductInventoryQueryDto> handle(FindOutOfStockProducts query) {
        return repo.findOutOfStockProducts();
    }
}
