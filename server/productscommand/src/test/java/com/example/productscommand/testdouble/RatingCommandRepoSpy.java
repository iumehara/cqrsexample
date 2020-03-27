package com.example.productscommand.testdouble;

import com.example.productscommand.entity.NewRating;
import com.example.productscommand.repo.RatingsCommandRepo;

public class RatingCommandRepoSpy implements RatingsCommandRepo {
    public NewRating create_arg;

    @Override
    public void create(NewRating rating) {
        this.create_arg = rating;
    }
}
