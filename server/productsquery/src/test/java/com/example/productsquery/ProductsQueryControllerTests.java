package com.example.productsquery;

import com.example.productsquery.dto.ProductInventoryQueryDto;
import com.example.productsquery.dto.ProductQueryDto;
import com.example.productsquery.repo.ProductsQueryRepo;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ProductsQueryControllerTests {
    @Test
    void findProductById() throws Exception {
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
        ProductsQueryHandler handler = new ProductsQueryHandler(repoStub);
        MockMvc controller = standaloneSetup(new ProductsQueryController(handler)).build();


        ResultActions resultActions = controller.perform(get("/query/products/1"));


        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(1)))
                .andExpect(jsonPath("$.name", equalTo("Paper Weight")))
                .andExpect(jsonPath("$.description", equalTo("Keeps paper on desk")))
                .andExpect(jsonPath("$.unitPrice", equalTo(1)))
                .andExpect(jsonPath("$.isOutOfStock", equalTo(false)))
                .andExpect(jsonPath("$.userRating", equalTo(4.3)));
    }

    @Test
    void findOutOfStockProducts() throws Exception {
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
        ProductsQueryHandler handler = new ProductsQueryHandler(repoStub);
        MockMvc controller = standaloneSetup(new ProductsQueryController(handler)).build();


        ResultActions resultActions = controller.perform(get("/query/products/out-of-stock"));


        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productId", equalTo(222)))
                .andExpect(jsonPath("$[0].name", equalTo("Paper (A4)")))
                .andExpect(jsonPath("$[0].currentStock", equalTo(0)))
                .andExpect(jsonPath("$[1].productId", equalTo(354)))
                .andExpect(jsonPath("$[1].name", equalTo("Stapler (red)")))
                .andExpect(jsonPath("$[1].currentStock", equalTo(0)));
    }
}
