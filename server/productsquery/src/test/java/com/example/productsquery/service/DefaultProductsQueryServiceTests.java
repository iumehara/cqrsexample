package com.example.productsquery.service;

import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;
import com.example.productsquery.repo.ProductsQueryRepo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultProductsQueryServiceTests {
    @Test
    void findProductById() {
        ProductsQueryRepo repoStub = new ProductsQueryRepo() {
            @Override
            public ProductQueryDto findById(int productId) {
                return new ProductQueryDto(1,
                        "Paper Weight",
                        "Keeps paper on desk",
                        1,
                        false,
                        4.3);
            }

            @Override
            public List<ProductInventoryQueryDto> findOutOfStockProducts() {
                return null;
            }
        };
        DefaultProductsQueryService service = new DefaultProductsQueryService(repoStub);


        ProductQueryDto product = service.findProductById(1);


        assertThat(product.getId()).isEqualTo(1);
        assertThat(product.getName()).isEqualTo("Paper Weight");
        assertThat(product.getDescription()).isEqualTo("Keeps paper on desk");
        assertThat(product.getUnitPrice()).isEqualTo(1);
        assertThat(product.getOutOfStock()).isEqualTo(false);
        assertThat(product.getUserRating()).isEqualTo(4.3);
    }

    @Test
    void findOutOfStockProducts() {
        ProductsQueryRepo repoStub = new ProductsQueryRepo() {
            @Override
            public ProductQueryDto findById(int productId) {
                return null;
            }

            @Override
            public List<ProductInventoryQueryDto> findOutOfStockProducts() {
                return asList(new ProductInventoryQueryDto(222, "Paper (A4)", 0),
                        new ProductInventoryQueryDto(354, "Stapler (red)", 0));
            }
        };
        DefaultProductsQueryService service = new DefaultProductsQueryService(repoStub);


        List<ProductInventoryQueryDto> products = service.findOutOfStockProducts();


        assertThat(products.get(0).getProductId()).isEqualTo(222);
        assertThat(products.get(0).getName()).isEqualTo("Paper (A4)");
        assertThat(products.get(0).getCurrentStock()).isEqualTo(0);
        assertThat(products.get(1).getProductId()).isEqualTo(354);
        assertThat(products.get(1).getName()).isEqualTo("Stapler (red)");
        assertThat(products.get(1).getCurrentStock()).isEqualTo(0);
    }
}
