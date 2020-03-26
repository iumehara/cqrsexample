package com.example.cqrsexample.productsquery;

import com.example.cqrsexample.productsquery.dto.ProductInventoryQueryDto;
import com.example.cqrsexample.productsquery.dto.ProductQueryDto;
import com.example.cqrsexample.productsquery.query.FindOutOfStockProducts;
import com.example.cqrsexample.productsquery.query.FindProductById;
import com.example.cqrsexample.productsquery.repo.ProductsQueryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsQueryHandler {
    private ProductsQueryRepo repo;

    public ProductsQueryHandler(ProductsQueryRepo repo) {
        this.repo = repo;
    }

    public ProductQueryDto handle(FindProductById query) {
        return repo.findById(query.getProductId());
    }

    List<ProductInventoryQueryDto> handle(FindOutOfStockProducts query) {
        return repo.findOutOfStockProducts();
    }
}
