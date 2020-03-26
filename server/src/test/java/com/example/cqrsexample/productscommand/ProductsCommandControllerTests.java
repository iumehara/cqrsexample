package com.example.cqrsexample.productscommand;

import com.example.cqrsexample.productscommand.entity.NewInventory;
import com.example.cqrsexample.productscommand.entity.NewProduct;
import com.example.cqrsexample.productscommand.entity.NewRating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ProductsCommandControllerTests {
    private MockMvc controller;
    private ProductCommandRepoSpy productsRepo;
    private InventoryCommandRepoSpy inventoryRepo;
    private RatingCommandRepoSpy ratingsRepo;

    @BeforeEach
    void setUp() {
        productsRepo = new ProductCommandRepoSpy();
        inventoryRepo = new InventoryCommandRepoSpy();
        ratingsRepo = new RatingCommandRepoSpy();
        ProductsCommandHandler commandHandler = new ProductsCommandHandler(productsRepo, inventoryRepo, ratingsRepo);
        ProductsCommandController productsCommandController = new ProductsCommandController(commandHandler);
        controller = standaloneSetup(productsCommandController).build();
    }

    @Test
    void addNewProduct() throws Exception {
        // language=json
        String jsonBody = "{\n" +
                "  \"name\": \"Paper Weight\",\n" +
                "  \"description\": \"Will keep your paper on your desk!\",\n" +
                "  \"unitPrice\": 500\n" +
                "}";


        ResultActions resultActions = controller.perform(
                post("/command/products")
                        .content(jsonBody)
                        .contentType(APPLICATION_JSON));


        assertThat(productsRepo.create_arg)
                .isEqualTo(new NewProduct("Paper Weight","Will keep your paper on your desk!",500));
        assertThat(inventoryRepo.create_arg)
                .isEqualTo(new NewInventory(productsRepo.create_returnValue, 0, true));
        resultActions.andExpect(status().isCreated());
    }

    @Test
    void rateProduct() throws Exception {
        // language=json
        String jsonbody = "{\n" +
                "  \"userId\": 30,\n" +
                "  \"rating\": 5\n" +
                "}";


        ResultActions resultActions = controller.perform(
                post("/command/products/1/ratings")
                        .content(jsonbody)
                        .contentType(APPLICATION_JSON));


        assertThat(ratingsRepo.create_arg).isEqualTo(new NewRating(1, 30, 5));
        resultActions.andExpect(status().isCreated());
    }
}
