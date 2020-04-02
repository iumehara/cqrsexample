package com.example.productscommand;

import com.example.productscommand.dto.NewProductRequestDto;
import com.example.productscommand.dto.NewRatingRequestDto;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("command/products")
public class ProductsCommandController {
    private ProductsCommandService service;

    public ProductsCommandController(ProductsCommandService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void addNewProduct(@RequestBody NewProductRequestDto newProductRequest) {
        service.addNewProduct(newProductRequest);
    }

    @PostMapping("{productId}/ratings")
    @ResponseStatus(CREATED)
    public void rateProduct(@PathVariable int productId,
                            @RequestBody NewRatingRequestDto ratingRequest) {
        service.rateProduct(productId, ratingRequest);
    }
}
