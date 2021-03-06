package com.example.productsquery.dataprojector.repo;

import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;
import com.example.productsquery.repo.ProductsQueryRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("PGProductsQueryRepo")
@Repository
public class PGProductsQueryRepo implements ProductsQueryRepo {
    private JdbcTemplate jdbcTemplate;

    public PGProductsQueryRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProductQueryDto findById(int productId) {
        // language=sql
        String sql = "SELECT p.id, p.name, p.description, p.unit_price, i.out_of_stock, r.rating \n" +
                "FROM products as p\n" +
                "LEFT JOIN ratings as r \n" +
                "ON r.product_id = p.id\n" +
                "LEFT JOIN inventory as i \n" +
                "ON i.product_id = p.id\n" +
                "WHERE p.id=:id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", productId);

        return new NamedParameterJdbcTemplate(jdbcTemplate)
                .queryForObject(sql,
                        params,
                        (rs, rowNum) -> new ProductQueryDto(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getInt("unit_price"),
                                rs.getBoolean("out_of_stock"),
                                rs.getDouble("rating")
                        )
                );
    }

    @Override
    public List<ProductInventoryQueryDto> findOutOfStockProducts() {
        // language=sql
        String sql = "SELECT p.id, p.name, i.current_stock \n" +
                "FROM products as p\n" +
                "LEFT JOIN inventory as i \n" +
                "ON i.product_id = p.id\n" +
                "WHERE i.out_of_stock=true";

        return jdbcTemplate
                .query(sql,
                        (rs, rowNum) -> new ProductInventoryQueryDto(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("current_stock")
                        )
                );
    }
}
