package com.example.cqrsexample.productscommand.repo;

import com.example.cqrsexample.productscommand.entity.NewRating;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class DBRatingCommandRepo implements RatingsCommandRepo {
    private JdbcTemplate jdbcTemplate;

    public DBRatingCommandRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(NewRating ratingDto) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("ratings")
                .usingGeneratedKeyColumns("id");

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("product_id", ratingDto.getProductId());
        parameters.addValue("rating", ratingDto.getRating());
        parameters.addValue("user_id", ratingDto.getUserId());

        simpleJdbcInsert.execute(parameters);
    }
}
