package com.example.cqrsexample.productscommand;

import com.example.cqrsexample.productscommand.entity.NewRating;
import com.example.cqrsexample.productscommand.repo.RatingsCommandRepo;

public class RatingCommandRepoSpy implements RatingsCommandRepo {
    NewRating create_arg;

    @Override
    public void create(NewRating rating) {
        this.create_arg = rating;
    }
}
