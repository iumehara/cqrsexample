package com.example.productscommand;

import com.example.productscommand.repo.InventoryCommandRepo;
import com.example.productscommand.repo.ProductsCommandRepo;
import com.example.productscommand.repo.RatingsCommandRepo;
import com.example.productscommand.command.AddNewProduct;
import com.example.productscommand.command.RateProduct;
import com.example.productscommand.entity.NewInventory;
import com.example.productscommand.entity.NewProduct;
import com.example.productscommand.entity.NewRating;
import org.springframework.stereotype.Service;

@Service
public class ProductsCommandHandler {
    private ProductsCommandRepo productsRepo;
    private InventoryCommandRepo inventoryRepo;
    private RatingsCommandRepo ratingsRepo;

    public ProductsCommandHandler(ProductsCommandRepo productsRepo,
                                  InventoryCommandRepo inventoryRepo,
                                  RatingsCommandRepo ratingsRepo) {
        this.productsRepo = productsRepo;
        this.inventoryRepo = inventoryRepo;
        this.ratingsRepo = ratingsRepo;
    }

    public void handle(AddNewProduct command) {
        NewProduct newProduct = new NewProduct(
                command.getName(),
                command.getDescription(),
                command.getUnitPrice()
        );
        int productId = productsRepo.create(newProduct);

        NewInventory inventory = new NewInventory(productId, 0, true);
        inventoryRepo.create(inventory);
    }

    public void handle(RateProduct command) {
        NewRating rating = new NewRating(
                command.getProductId(),
                command.getUserId(),
                command.getRating()
        );
        this.ratingsRepo.create(rating);
    }
}
