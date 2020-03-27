package com.example.productsquery.dto;

import java.util.Objects;

public class ProductInventoryQueryDto {
    public int productId;
    public String name;
    public int currentStock;

    public ProductInventoryQueryDto(int productId, String name, int currentStock) {
        this.productId = productId;
        this.name = name;
        this.currentStock = currentStock;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInventoryQueryDto that = (ProductInventoryQueryDto) o;
        return productId == that.productId &&
                currentStock == that.currentStock &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, currentStock);
    }

    @Override
    public String toString() {
        return "ProductInventory{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", currentStock=" + currentStock +
                '}';
    }
}
