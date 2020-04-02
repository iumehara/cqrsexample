package com.example.messagebroker.message.command;

import com.example.messagebroker.message.Command;
import com.example.messagebroker.QueueName;

import java.util.Objects;
import java.util.UUID;

import static com.example.messagebroker.QueueName.RATE_PRODUCT;

public class RateProduct implements Command {
    private UUID id;
    private QueueName queueName;
    private int productId;
    private int rating;
    private int userId;

    public RateProduct(int productId, int rating, int userId) {
        this.id = UUID.randomUUID();
        this.queueName = RATE_PRODUCT;
        this.productId = productId;
        this.rating = rating;
        this.userId = userId;
    }

    public RateProduct() {
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public QueueName getQueueName() {
        return RATE_PRODUCT;
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
                Objects.equals(id, that.id) &&
                queueName == that.queueName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, queueName, productId, rating, userId);
    }

    @Override
    public String toString() {
        return "RateProduct{" +
                "id=" + id +
                ", queueName=" + queueName +
                ", productId=" + productId +
                ", rating=" + rating +
                ", userId=" + userId +
                '}';
    }
}
