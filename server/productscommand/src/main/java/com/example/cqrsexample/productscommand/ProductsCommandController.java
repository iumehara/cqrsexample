package com.example.cqrsexample.productscommand;

import com.example.cqrsexample.productscommand.command.AddNewProduct;
import com.example.cqrsexample.productscommand.dto.NewProductRequestDto;
import com.example.cqrsexample.productscommand.dto.NewRatingRequestDto;
import com.example.cqrsexample.productscommand.command.RateProduct;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("command/products")
public class ProductsCommandController {
    private ProductsCommandHandler commandHandler;

    public ProductsCommandController(ProductsCommandHandler commandHandler) {
        System.out.println("commandHandler = " + commandHandler);
        this.commandHandler = commandHandler;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void addNewProduct(@RequestBody NewProductRequestDto newProductRequest) {
        AddNewProduct command = new AddNewProduct(newProductRequest.getName(),
                newProductRequest.getDescription(),
                newProductRequest.getUnitPrice());
        commandHandler.handle(command);
    }

    @PostMapping("{productId}/ratings")
    @ResponseStatus(CREATED)
    public void rateProduct(@PathVariable int productId,
                            @RequestBody NewRatingRequestDto ratingRequest) {
        RateProduct command = new RateProduct(productId, ratingRequest.getRating(), ratingRequest.getUserId());
        commandHandler.handle(command);
    }
}
