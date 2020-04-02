package com.example.messagebroker.message.event;

import com.example.messagebroker.message.Event;
import com.example.messagebroker.QueueName;

import java.util.Objects;
import java.util.UUID;

public class ProductRated implements Event {
    private UUID id;
    private QueueName queueName;

    public ProductRated(UUID id, QueueName queueName) {
        this.id = id;
        this.queueName = queueName;
    }

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public QueueName getQueueName() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRated that = (ProductRated) o;
        return Objects.equals(id, that.id) &&
                queueName == that.queueName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, queueName);
    }

    @Override
    public String toString() {
        return "ProductRated{" +
                "id=" + id +
                ", queueName=" + queueName +
                '}';
    }
}
