package com.example.cqrsexample.productscommand.repo;

import com.example.cqrsexample.productscommand.entity.NewRating;

public interface RatingsCommandRepo {
    void create(NewRating ratingDto);
}
