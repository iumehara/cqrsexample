package com.example.cqrsexample.productscommand.command;

import java.util.Objects;
import java.util.UUID;

public class AddNewProduct implements Command {
    public UUID id;
    public String name;
    public String description;
    public int unitPrice;

    public AddNewProduct(String name, String description, int unitPrice) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    @Override
    public UUID getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddNewProduct that = (AddNewProduct) o;
        return unitPrice == that.unitPrice &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, unitPrice);
    }

    @Override
    public String toString() {
        return "AddNewProduct{" +
                "Name='" + name + '\'' +
                ", Description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
