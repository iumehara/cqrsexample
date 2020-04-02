package com.example.productsquery.dataprojector.repo;

import com.example.productsquery.dto.ProductQueryDto;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MongoProductsCommandRepo implements ProductsCommandRepo {
    private MongoTemplate mongoTemplate;

    public MongoProductsCommandRepo(MongoTemplate testTemplate) {
        this.mongoTemplate = testTemplate;
    }

    @Override
    public void create(ProductQueryDto dto) {
        this.mongoTemplate.insert(dto, "products");
    }
}
