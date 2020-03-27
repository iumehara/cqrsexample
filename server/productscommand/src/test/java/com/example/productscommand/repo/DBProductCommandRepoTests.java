package com.example.productscommand.repo;

import com.example.productscommand.entity.NewProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DBProductCommandRepoTests {
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        DataSource dataSource = DataSourceTestHelper.buildH2();
        DataSourceTestHelper.setupDb(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    void create() {
        DBProductCommandRepo repo = new DBProductCommandRepo(jdbcTemplate);
        NewProduct newProduct = new NewProduct("Stapler", "red stapler", 1000);


        int id = repo.create(newProduct);


        assertThat(id).isEqualTo(1);
        List<Map<String, Object>> results = jdbcTemplate.query(
                "select * from products",
                (rs, rowNumber) -> mapFromResultSet(rs));

        assertThat(results.size()).isEqualTo(1);
        Map<String, Object> firstResult = results.get(0);
        assertThat(firstResult.get("id")).isEqualTo(1);
        assertThat(firstResult.get("name")).isEqualTo("Stapler");
        assertThat(firstResult.get("description")).isEqualTo("red stapler");
        assertThat(firstResult.get("unit_price")).isEqualTo(1000);
    }

    private Map<String, Object> mapFromResultSet(ResultSet rs) throws SQLException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", rs.getObject("id"));
        map.put("name", rs.getObject("name"));
        map.put("description", rs.getObject("description"));
        map.put("unit_price", rs.getObject("unit_price"));
        return map;
    }
}
