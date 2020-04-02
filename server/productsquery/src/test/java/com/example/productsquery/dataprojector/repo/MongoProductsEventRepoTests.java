package com.example.productsquery.dataprojector.repo;

import com.example.productsquery.dto.ProductQueryDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class MongoProductsEventRepoTests {
    @Autowired
    MongoTemplate testTemplate;

    @AfterEach
    void tearDown() {
        testTemplate.dropCollection("products");
    }

    @Test
    void findById() {
        MongoProductsCommandRepo repo = new MongoProductsCommandRepo(testTemplate);
        ProductQueryDto productToSave = new ProductQueryDto(123,
                "pen",
                "writes stuff",
                10,
                false,
                10.0);


        repo.create(productToSave);


        ProductQueryDto actualProduct = testTemplate.findById(123, ProductQueryDto.class, "products");
        assertThat(productToSave).isEqualTo(actualProduct);
    }
}
