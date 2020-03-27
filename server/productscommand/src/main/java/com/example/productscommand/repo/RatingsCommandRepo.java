package com.example.productscommand.repo;

import com.example.productscommand.entity.NewRating;

public interface RatingsCommandRepo {
    void create(NewRating ratingDto);
}
