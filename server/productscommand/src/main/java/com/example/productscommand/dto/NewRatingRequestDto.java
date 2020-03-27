package com.example.productscommand.dto;

import java.util.Objects;

public class NewRatingRequestDto {
    private int userId;
    private int rating;

    public NewRatingRequestDto() {
    }

    public NewRatingRequestDto(int userId, int rating) {
        this.userId = userId;
        this.rating = rating;
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
        NewRatingRequestDto that = (NewRatingRequestDto) o;
        return userId == that.userId &&
                rating == that.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, rating);
    }

    @Override
    public String toString() {
        return "RatingRequestDto{" +
                "userId=" + userId +
                ", rating=" + rating +
                '}';
    }
}
