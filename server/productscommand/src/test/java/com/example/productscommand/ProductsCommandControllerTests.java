//package com.example.productscommand;
//
//import com.example.productscommand.entity.NewInventory;
//import com.example.productscommand.entity.NewProduct;
//import com.example.productscommand.entity.NewRating;
//import com.example.productscommand.handler.ProductsCommandHandler;
//import com.example.productscommand.testdouble.InventoryCommandRepoSpy;
//import com.example.productscommand.testdouble.ProductCommandRepoSpy;
//import com.example.productscommand.testdouble.RatingCommandRepoSpy;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
//public class ProductsCommandControllerTests {
//    private ProductCommandRepoSpy productRepo;
//    private InventoryCommandRepoSpy inventoryRepo;
//    private RatingCommandRepoSpy ratingRepo;
//    private MockMvc controller;
//
//    @BeforeEach
//    void setUp() {
//        productRepo = new ProductCommandRepoSpy();
//        inventoryRepo = new InventoryCommandRepoSpy();
//        ratingRepo = new RatingCommandRepoSpy();
//
//        ProductsCommandHandler commandHandler = new ProductsCommandHandler(productRepo, inventoryRepo, ratingRepo);
//        ProductsCommandController productsCommandController = new ProductsCommandController(commandHandler);
//        controller = standaloneSetup(productsCommandController).build();
//    }
//
//    @Test
//    void addNewProduct() throws Exception {
//        // language=json
//        String jsonBody = "{\n" +
//                "  \"name\": \"Paper Weight\",\n" +
//                "  \"description\": \"Will keep your paper on your desk!\",\n" +
//                "  \"unitPrice\": 500\n" +
//                "}";
//
//
//        ResultActions resultActions = controller.perform(
//                post("/command/products")
//                        .content(jsonBody)
//                        .contentType(APPLICATION_JSON));
//
//
//        assertThat(productRepo.create_arg)
//                .isEqualTo(new NewProduct("Paper Weight", "Will keep your paper on your desk!", 500));
//        Assertions.assertThat(inventoryRepo.create_arg)
//                .isEqualTo(new NewInventory(productRepo.create_returnValue, 0, true));
//        resultActions.andExpect(status().isCreated());
//    }
//
//    @Test
//    void rateProduct() throws Exception {
//        // language=json
//        String jsonbody = "{\n" +
//                "  \"userId\": 30,\n" +
//                "  \"rating\": 5\n" +
//                "}";
//
//
//        ResultActions resultActions = controller.perform(
//                post("/command/products/1/ratings")
//                        .content(jsonbody)
//                        .contentType(APPLICATION_JSON));
//
//
//        Assertions.assertThat(ratingRepo.create_arg).isEqualTo(new NewRating(1, 30, 5));
//        resultActions.andExpect(status().isCreated());
//    }
//}
