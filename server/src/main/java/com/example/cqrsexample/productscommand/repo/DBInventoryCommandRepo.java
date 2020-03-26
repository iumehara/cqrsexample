package com.example.cqrsexample.productscommand.repo;

import com.example.cqrsexample.productscommand.entity.NewInventory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class DBInventoryCommandRepo implements InventoryCommandRepo {
    private JdbcTemplate jdbcTemplate;

    public DBInventoryCommandRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(NewInventory inventory) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("inventory")
                .usingGeneratedKeyColumns("id");

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("product_id", inventory.productId);
        parameters.addValue("current_stock", inventory.currentStock);
        parameters.addValue("out_of_stock", inventory.outOfStock);

        return simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
    }
}
