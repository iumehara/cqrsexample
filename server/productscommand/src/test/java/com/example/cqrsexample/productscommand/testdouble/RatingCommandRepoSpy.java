package com.example.cqrsexample.productscommand.testdouble;

import com.example.cqrsexample.productscommand.entity.NewRating;
import com.example.cqrsexample.productscommand.repo.RatingsCommandRepo;

public class RatingCommandRepoSpy implements RatingsCommandRepo {
    public NewRating create_arg;

    @Override
    public void create(NewRating rating) {
        this.create_arg = rating;
    }
}
