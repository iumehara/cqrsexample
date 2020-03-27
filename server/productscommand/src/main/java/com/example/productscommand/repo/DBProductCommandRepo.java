package com.example.productscommand.repo;

import com.example.productscommand.entity.NewProduct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class DBProductCommandRepo implements ProductsCommandRepo {
    private JdbcTemplate jdbcTemplate;

    public DBProductCommandRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(NewProduct product) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("products")
                .usingGeneratedKeyColumns("id");

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("name", product.name);
        parameters.addValue("description", product.description);
        parameters.addValue("unit_price", product.unitPrice);

        return simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
    }
}
