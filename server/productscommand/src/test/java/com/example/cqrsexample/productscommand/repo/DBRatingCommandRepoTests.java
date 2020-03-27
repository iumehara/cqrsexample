package com.example.cqrsexample.productscommand.repo;

import com.example.cqrsexample.productscommand.entity.NewRating;
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

public class DBRatingCommandRepoTests {
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
        DBRatingCommandRepo repo = new DBRatingCommandRepo(jdbcTemplate);


        NewRating rating = new NewRating(1, 234, 55);
        repo.create(rating);


        List<Map<String, Object>> results = jdbcTemplate.query(
                "select * from ratings",
                (rs, rowNumber) -> mapFromResultSet(rs));
        assertThat(results.size()).isEqualTo(1);
        Map<String, Object> firstResult = results.get(0);
        assertThat(firstResult.get("id")).isEqualTo(1);
        assertThat(firstResult.get("product_id")).isEqualTo(1);
        assertThat(firstResult.get("rating")).isEqualTo(55);
        assertThat(firstResult.get("user_id")).isEqualTo(234);
    }

    private Map<String, Object> mapFromResultSet(ResultSet rs) throws SQLException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", rs.getObject("id"));
        map.put("product_id", rs.getObject("product_id"));
        map.put("rating", rs.getObject("rating"));
        map.put("user_id", rs.getObject("user_id"));
        return map;
    }
}
