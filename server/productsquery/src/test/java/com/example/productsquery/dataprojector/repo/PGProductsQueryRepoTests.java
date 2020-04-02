package com.example.productsquery.dataprojector.repo;

import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;
import com.example.productsquery.repo.DataSourceTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PGProductsQueryRepoTests {
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        DataSource dataSource = DataSourceTestHelper.buildH2();
        DataSourceTestHelper.setupDB(dataSource);
        DataSourceTestHelper.seedDb(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    void findById() {
        PGProductsQueryRepo repo = new PGProductsQueryRepo(jdbcTemplate);
        ProductQueryDto product = repo.findById(111);

        assertThat(product).isEqualTo(new ProductQueryDto(111,
                "stapler",
                "staples things",
                500,
                false,
                10.0));
    }

    @Test
    void findOutOfStockProducts() {
        PGProductsQueryRepo repo = new PGProductsQueryRepo(jdbcTemplate);
        List<ProductInventoryQueryDto> outOfStockProducts = repo.findOutOfStockProducts();

        assertThat(outOfStockProducts.size()).isEqualTo(1);
        assertThat(outOfStockProducts.get(0)).isEqualTo(new ProductInventoryQueryDto(113,
                "Paper (A4)",
                0));
    }
}
