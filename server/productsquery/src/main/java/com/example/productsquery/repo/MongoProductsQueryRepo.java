package com.example.productsquery.repo;

import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public class MongoProductsQueryRepo implements ProductsQueryRepo {
    private MongoTemplate mongoTemplate;
    private String collectionName;

    public MongoProductsQueryRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
        this.collectionName = "products";
    }

    @Override
    public ProductQueryDto findById(int productId) {
        return this.mongoTemplate.findById(productId, ProductQueryDto.class, this.collectionName);
    }

    @Override
    public List<ProductInventoryQueryDto> findOutOfStockProducts() {
        return null;
    }
}
