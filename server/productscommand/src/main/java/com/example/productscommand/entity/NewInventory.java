package com.example.productscommand.entity;

import java.util.Objects;

public class NewInventory {
    public int productId;
    public int currentStock;
    public boolean outOfStock;

    public NewInventory(int productId, int currentStock, boolean outOfStock) {
        this.productId = productId;
        this.currentStock = currentStock;
        this.outOfStock = outOfStock;
    }

    public int getProductId() {
        return productId;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public boolean isOutOfStock() {
        return outOfStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewInventory that = (NewInventory) o;
        return productId == that.productId &&
                currentStock == that.currentStock &&
                outOfStock == that.outOfStock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, currentStock, outOfStock);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "productId=" + productId +
                ", currentStock=" + currentStock +
                ", outOfStock=" + outOfStock +
                '}';
    }
}
