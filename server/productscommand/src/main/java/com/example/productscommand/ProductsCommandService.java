package com.example.productscommand;

import com.example.productscommand.dto.NewProductRequestDto;
import com.example.productscommand.dto.NewRatingRequestDto;
import com.example.messagebroker.message.command.AddNewProduct;
import com.example.messagebroker.message.command.RateProduct;
import com.example.messagebroker.Sender;
import org.springframework.stereotype.Service;

@Service
public class ProductsCommandService {
    private Sender sender;

    public ProductsCommandService(Sender sender) {
        this.sender = sender;
    }

    public void addNewProduct(NewProductRequestDto newProductRequest) {
        AddNewProduct command = new AddNewProduct(newProductRequest.getName(),
                newProductRequest.getDescription(),
                newProductRequest.getUnitPrice());

        sender.send(command);
    }

    public void rateProduct(int productId, NewRatingRequestDto ratingRequest) {
        RateProduct command = new RateProduct(productId, ratingRequest.getRating(), ratingRequest.getUserId());
        sender.send(command);
    }
}
