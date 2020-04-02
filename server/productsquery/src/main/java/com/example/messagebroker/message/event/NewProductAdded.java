package com.example.messagebroker.message.event;

import com.example.messagebroker.message.Event;
import com.example.messagebroker.QueueName;

import java.util.Objects;
import java.util.UUID;

public class NewProductAdded implements Event {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private QueueName queueName;
    private int productId;

    public NewProductAdded(UUID id, QueueName queueName, int productId) {
        this.id = id;
        this.queueName = queueName;
        this.productId = productId;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public QueueName getQueueName() {
        return queueName;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewProductAdded that = (NewProductAdded) o;
        return productId == that.productId &&
                Objects.equals(id, that.id) &&
                queueName == that.queueName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, queueName, productId);
    }

    @Override
    public String toString() {
        return "NewProductAdded{" +
                "id=" + id +
                ", queueName=" + queueName +
                ", productId=" + productId +
                '}';
    }
}
