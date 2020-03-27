package com.example.cqrsexample.productscommand;

import com.example.cqrsexample.productscommand.repo.InventoryCommandRepo;
import com.example.cqrsexample.productscommand.repo.ProductsCommandRepo;
import com.example.cqrsexample.productscommand.repo.RatingsCommandRepo;
import com.example.cqrsexample.productscommand.command.AddNewProduct;
import com.example.cqrsexample.productscommand.command.RateProduct;
import com.example.cqrsexample.productscommand.entity.NewInventory;
import com.example.cqrsexample.productscommand.entity.NewProduct;
import com.example.cqrsexample.productscommand.entity.NewRating;
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
