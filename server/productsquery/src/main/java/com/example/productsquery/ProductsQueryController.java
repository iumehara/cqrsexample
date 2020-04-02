package com.example.productsquery;

import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;
import com.example.productsquery.service.ProductsQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("query/products")
public class ProductsQueryController {
    ProductsQueryService service;

    public ProductsQueryController(ProductsQueryService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    ProductQueryDto findProductById(@PathVariable int id) {
        return service.findProductById(id);
    }

    @GetMapping("out-of-stock")
    List<ProductInventoryQueryDto> findOutOfStockProducts() {
        return service.findOutOfStockProducts();
    }
}
