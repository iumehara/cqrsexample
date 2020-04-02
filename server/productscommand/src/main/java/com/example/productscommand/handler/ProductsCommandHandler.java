package com.example.productscommand.handler;

import com.example.productscommand.entity.NewInventory;
import com.example.productscommand.entity.NewProduct;
import com.example.productscommand.entity.NewRating;
import com.example.messagebroker.message.command.AddNewProduct;
import com.example.messagebroker.message.command.RateProduct;
import com.example.messagebroker.message.event.NewProductAdded;
import com.example.messagebroker.message.event.ProductRated;
import com.example.messagebroker.Sender;
import com.example.productscommand.repo.InventoryCommandRepo;
import com.example.productscommand.repo.ProductsCommandRepo;
import com.example.productscommand.repo.RatingsCommandRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductsCommandHandler {
    private ProductsCommandRepo productsRepo;
    private InventoryCommandRepo inventoryRepo;
    private RatingsCommandRepo ratingsRepo;
    private Sender sender;

    public ProductsCommandHandler(ProductsCommandRepo productsRepo,
                                  InventoryCommandRepo inventoryRepo,
                                  RatingsCommandRepo ratingsRepo,
                                  Sender sender) {
        this.productsRepo = productsRepo;
        this.inventoryRepo = inventoryRepo;
        this.ratingsRepo = ratingsRepo;
        this.sender = sender;
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

        this.sender.send(new NewProductAdded(productId));
    }

    public void handle(RateProduct command) {
        NewRating rating = new NewRating(
                command.getProductId(),
                command.getUserId(),
                command.getRating()
        );
        this.ratingsRepo.create(rating);

        this.sender.send(new ProductRated());
    }
}
