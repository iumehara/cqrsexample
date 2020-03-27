package com.example.productsquery;

import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;
import com.example.productsquery.repo.ProductsQueryRepo;
import com.example.productsquery.query.FindOutOfStockProducts;
import com.example.productsquery.query.FindProductById;
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

    public List<ProductInventoryQueryDto> handle(FindOutOfStockProducts query) {
        return repo.findOutOfStockProducts();
    }
}
