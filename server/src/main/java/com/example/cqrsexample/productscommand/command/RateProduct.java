package com.example.cqrsexample.productscommand.command;

import java.util.Objects;
import java.util.UUID;

public class RateProduct implements Command {
    private UUID id;
    private int productId;
    private int rating;
    private int userId;

    public RateProduct(int productId, int rating, int userId) {
        this.id = UUID.randomUUID();
        this.productId = productId;
        this.rating = rating;
        this.userId = userId;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public int getRating() {
        return rating;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RateProduct that = (RateProduct) o;
        return productId == that.productId &&
                rating == that.rating &&
                userId == that.userId &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, rating, userId);
    }

    @Override
    public String toString() {
        return "RateProduct{" +
                "id=" + id +
                ", productId=" + productId +
                ", rating=" + rating +
                ", userId=" + userId +
                '}';
    }
}
