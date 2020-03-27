package com.example.productsquery.dto;

import java.util.Objects;

public class ProductQueryDto {
    public int id;
    public String name;
    public String description;
    public int unitPrice;
    public Boolean isOutOfStock;
    public Double userRating;

    public ProductQueryDto(int id,
                           String name,
                           String description,
                           int unitPrice,
                           Boolean isOutOfStock,
                           Double userRating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.isOutOfStock = isOutOfStock;
        this.userRating = userRating;
    }

    public int getId() {
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

    public Boolean getOutOfStock() {
        return isOutOfStock;
    }

    public Double getUserRating() {
        return userRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductQueryDto that = (ProductQueryDto) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(isOutOfStock, that.isOutOfStock) &&
                Objects.equals(userRating, that.userRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, unitPrice, isOutOfStock, userRating);
    }

    @Override
    public String toString() {
        return "ProductDisplay{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", Description='" + description + '\'' +
                ", UnitPrice=" + unitPrice +
                ", IsOutOfStock=" + isOutOfStock +
                ", UserRating=" + userRating +
                '}';
    }
}
