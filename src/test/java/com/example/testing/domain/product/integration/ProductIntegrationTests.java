package com.example.testing.domain.product.integration;

import com.example.testing.domain.product.Product;
import com.example.testing.domain.product.ProductRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductIntegrationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ProductRepository productRepository;

    private List<Product> dummyProducts;

    @BeforeEach
    public void setUp() {
        dummyProducts = productRepository.saveAll(Stream.of(new Product(UUID.randomUUID(), "shirt", 49), new Product(UUID.randomUUID(), "sandwich", 8)).collect(Collectors.toList()));
    }

    @Test
    public void retrieveAll_requestAllProducts_expectAllProductsAsDTOS() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/products")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").value(Matchers.containsInAnyOrder(dummyProducts.get(0).getId().toString(), dummyProducts.get(1).getId().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].name").value(Matchers.containsInAnyOrder(dummyProducts.get(0).getName(), dummyProducts.get(1).getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].price").doesNotExist());
    }

    @Test
    public void retrieveById_requestProductById_expectProductAsDTO() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/products/{id}", dummyProducts.get(0).getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyProducts.get(0).getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(dummyProducts.get(0).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").doesNotExist());
    }

    @Test
    @Disabled("Not implemented yet")
    public void create_requestProductDTOToBeCreated_expectCreatedProductAsDTO() throws Exception {}

    @Test
    @Disabled("Not implemented yet")
    public void updateProduct_requestProductDTOToBeUpdated_expectUpdatedProductDTO() throws Exception {}

    @Test
    @Disabled("Not implemented yet")
    public void deleteProductById_requestDeletionOfProductById_expectAppropriateState() throws Exception {}
}
