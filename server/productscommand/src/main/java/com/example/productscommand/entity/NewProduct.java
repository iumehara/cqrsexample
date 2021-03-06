package com.example.productscommand.entity;

import java.util.Objects;

public class NewProduct {
    public String name;
    public String description;
    public int unitPrice;

    public NewProduct(String name, String description, int unitPrice) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
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
        NewProduct that = (NewProduct) o;
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
        return "NewProduct{" +
                "Name='" + name + '\'' +
                ", Description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
