package com.example.productsquery.service;

import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;
import com.example.productsquery.repo.ProductsQueryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProductsQueryService implements ProductsQueryService {
    private ProductsQueryRepo repo;

    public DefaultProductsQueryService(ProductsQueryRepo repo) {
        this.repo = repo;
    }

    @Override
    public ProductQueryDto findProductById(int id) {
        return repo.findById(id);
    }

    @Override
    public List<ProductInventoryQueryDto> findOutOfStockProducts() {
        return repo.findOutOfStockProducts();
    }
}
