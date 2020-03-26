package com.example.cqrsexample.productsquery;

import com.example.cqrsexample.productsquery.dto.ProductInventoryQueryDto;
import com.example.cqrsexample.productsquery.dto.ProductQueryDto;
import com.example.cqrsexample.productsquery.query.FindOutOfStockProducts;
import com.example.cqrsexample.productsquery.query.FindProductById;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("query/products")
public class ProductsQueryController {
    ProductsQueryHandler handler;

    public ProductsQueryController(ProductsQueryHandler handler) {
        this.handler = handler;
    }

    @GetMapping("{id}")
    ProductQueryDto findProductById(@PathVariable int id) {
        FindProductById findProductById = new FindProductById(id);
        return handler.handle(findProductById);
    }

    @GetMapping("out-of-stock")
    List<ProductInventoryQueryDto> findOutOfStockProducts() {
        FindOutOfStockProducts findOutOfStockProducts = new FindOutOfStockProducts();
        return handler.handle(findOutOfStockProducts);
    }
}
