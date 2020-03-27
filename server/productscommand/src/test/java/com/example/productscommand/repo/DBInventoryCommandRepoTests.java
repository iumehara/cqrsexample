package com.example.productscommand.repo;

import com.example.productscommand.entity.NewInventory;
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


public class DBInventoryCommandRepoTests {
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        DataSource dataSource = DataSourceTestHelper.buildH2();
        DataSourceTestHelper.setupDb(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);

        //language=sql
        String sql = "insert into products(name, description, unit_price) values ('stapler', 'staples things', 500)";
        jdbcTemplate.execute(sql);
    }

    @Test
    void create() {
        DBInventoryCommandRepo repo = new DBInventoryCommandRepo(jdbcTemplate);
        NewInventory inventory = new NewInventory(1, 100, false);


        repo.create(inventory);


        List<Map<String, Object>> results = jdbcTemplate.query(
                "select * from inventory",
                (rs, rowNumber) -> mapFromResultSet(rs));

        assertThat(results.size()).isEqualTo(1);
        Map<String, Object> firstResult = results.get(0);
        assertThat(firstResult.get("id")).isEqualTo(1);
        assertThat(firstResult.get("product_id")).isEqualTo(1);
        assertThat(firstResult.get("current_stock")).isEqualTo(100);
        assertThat(firstResult.get("out_of_stock")).isEqualTo(false);
    }

    private Map<String, Object> mapFromResultSet(ResultSet rs) throws SQLException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", rs.getObject("id"));
        map.put("product_id", rs.getObject("product_id"));
        map.put("current_stock", rs.getObject("current_stock"));
        map.put("out_of_stock", rs.getObject("out_of_stock"));
        return map;
    }
}
