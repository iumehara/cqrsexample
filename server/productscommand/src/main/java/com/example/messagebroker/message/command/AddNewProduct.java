package com.example.messagebroker.message.command;

import com.example.messagebroker.message.Command;
import com.example.messagebroker.QueueName;

import java.util.Objects;
import java.util.UUID;

import static com.example.messagebroker.QueueName.ADD_NEW_PRODUCT;

public class AddNewProduct implements Command {
    private UUID id;
    private QueueName queueName;
    private String name;
    private String description;
    private int unitPrice;

    public AddNewProduct(String name, String description, int unitPrice) {
        this.id = UUID.randomUUID();
        this.queueName = ADD_NEW_PRODUCT;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public AddNewProduct() {
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public QueueName getQueueName() {
        return queueName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setQueueName(QueueName queueName) {
        this.queueName = queueName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddNewProduct that = (AddNewProduct) o;
        return unitPrice == that.unitPrice &&
                Objects.equals(id, that.id) &&
                queueName == that.queueName &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, queueName, name, description, unitPrice);
    }

    @Override
    public String toString() {
        return "AddNewProduct{" +
                "id=" + id +
                ", queueName=" + queueName +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
