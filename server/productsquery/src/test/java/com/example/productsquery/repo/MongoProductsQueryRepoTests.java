package com.example.productsquery.repo;

import com.example.productsquery.dto.ProductQueryDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class MongoProductsQueryRepoTests {
    @Autowired
    MongoTemplate testTemplate;

    @BeforeEach
    void setUp() {
        testTemplate.insert(
                new ProductQueryDto(123, "pen", "writes stuff", 10, false, 10.0),
                "products");
    }

    @AfterEach
    void tearDown() {
        testTemplate.dropCollection("products");
    }

    @Test
    void findById() {
        MongoProductsQueryRepo repo = new MongoProductsQueryRepo(testTemplate);

        ProductQueryDto actualProduct = repo.findById(123);

        ProductQueryDto expectedProduct = new ProductQueryDto(123, "pen", "writes stuff", 10, false, 10.0);
        assertThat(actualProduct).isEqualTo(expectedProduct);
    }
}
