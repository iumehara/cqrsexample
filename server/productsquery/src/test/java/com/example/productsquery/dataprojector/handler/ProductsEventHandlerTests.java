package com.example.productsquery.dataprojector.handler;

import com.example.messagebroker.message.event.NewProductAdded;
import com.example.productsquery.dataprojector.repo.SpyProductsCommandRepo;
import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;
import com.example.productsquery.repo.ProductsQueryRepo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static com.example.messagebroker.QueueName.PRODUCT_RATED;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductsEventHandlerTests {
    @Test
    void handle_addNewProduct() {
        ProductsQueryRepo stubQueryRepo = new ProductsQueryRepo() {

            @Override
            public ProductQueryDto findById(int productId) {
                return new ProductQueryDto(productId,
                        "pencil",
                        "writes things",
                        10,
                        false,
                        10.0);
            }

            @Override
            public List<ProductInventoryQueryDto> findOutOfStockProducts() {
                return null;
            }
        };
        SpyProductsCommandRepo spyProductsCommandRepo = new SpyProductsCommandRepo();
        ProductsEventHandler handler = new ProductsEventHandler(stubQueryRepo, spyProductsCommandRepo);


        handler.handle(new NewProductAdded(UUID.randomUUID(), PRODUCT_RATED, 124));


        assertThat(spyProductsCommandRepo.getCreate_args())
                .isEqualTo(new ProductQueryDto(124,
                        "pencil",
                        "writes things",
                        10,
                        false,
                        10.0));
    }
}
