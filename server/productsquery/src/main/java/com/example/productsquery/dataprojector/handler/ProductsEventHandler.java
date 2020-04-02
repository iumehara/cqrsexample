package com.example.productsquery.dataprojector.handler;

import com.example.messagebroker.message.event.NewProductAdded;
import com.example.messagebroker.message.event.ProductRated;
import com.example.productsquery.dataprojector.repo.ProductsCommandRepo;
import com.example.productsquery.dto.ProductQueryDto;
import com.example.productsquery.repo.ProductsQueryRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductsEventHandler {
    private final ProductsQueryRepo pgQueryRepo;
    private final ProductsCommandRepo mongoCommandRepo;

    public ProductsEventHandler(@Qualifier("PGProductsQueryRepo") ProductsQueryRepo pgQueryRepo,
                                ProductsCommandRepo mongoCommandRepo) {
        this.pgQueryRepo = pgQueryRepo;
        this.mongoCommandRepo = mongoCommandRepo;
    }

    public void handle(NewProductAdded command) {
        ProductQueryDto dto = pgQueryRepo.findById(command.getProductId());
        mongoCommandRepo.create(dto);
    }

    public void handle(ProductRated command) {
    }
}
