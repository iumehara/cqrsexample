package com.example.cqrsexample.productscommand.entity;

import java.util.Objects;

public class NewRatingOld {
    private int productId;
    private int userId;
    private int rating;

    public NewRatingOld(int productId, int userId, int rating) {
        this.productId = productId;
        this.userId = userId;
        this.rating = rating;
    }

    public int getProductId() {
        return productId;
    }

    public int getUserId() {
        return userId;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewRatingOld that = (NewRatingOld) o;
        return productId == that.productId &&
                userId == that.userId &&
                rating == that.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, userId, rating);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "productId=" + productId +
                ", userId=" + userId +
                ", rating=" + rating +
                '}';
    }
}
