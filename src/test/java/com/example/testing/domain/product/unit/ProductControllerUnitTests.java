package com.example.testing.domain.product.unit;

import com.example.testing.domain.product.Product;
import com.example.testing.domain.product.ProductService;
import com.example.testing.domain.product.dto.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerUnitTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    private Product dummyProduct;
    private List<Product> dummyProducts;

    @BeforeEach
    public void setUp() {
        dummyProduct = new Product(UUID.randomUUID(), "kettle", 107);
        dummyProducts = Stream.of(new Product(UUID.randomUUID(), "shirt", 49), new Product(UUID.randomUUID(), "sandwich", 8)).collect(Collectors.toList());
    }

    @Test
    public void retrieveAll_requestAllProducts_expectAllProductsAsDTOS() throws Exception {
        given(productService.findAll()).willReturn(dummyProducts);

        mvc.perform(MockMvcRequestBuilders
                        .get("/products")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").value(Matchers.containsInAnyOrder(dummyProducts.get(0).getId().toString(), dummyProducts.get(1).getId().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].name").value(Matchers.containsInAnyOrder(dummyProducts.get(0).getName(), dummyProducts.get(1).getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].price").doesNotExist());

        verify(productService, times(1)).findAll();
    }

    @Test
    public void retrieveById_requestProductById_expectProductAsDTO() throws Exception {
        given(productService.findById(any(UUID.class))).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0)))
                throw new NoSuchElementException("No such product present");
            return dummyProduct;
        });

        mvc.perform(MockMvcRequestBuilders
                        .get("/products/{id}", dummyProduct.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyProduct.getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(dummyProduct.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").doesNotExist());

        ArgumentCaptor<UUID> productArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(productService, times(1)).findById(productArgumentCaptor.capture());
        assertThat(productArgumentCaptor.getValue()).isEqualTo(dummyProduct.getId());
    }

    @Test
    public void create_requestProductDTOToBeCreated_expectCreatedProductAsDTO() throws Exception {
        UUID uuid = UUID.randomUUID();

        given(productService.save(any(Product.class))).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0))) throw new Exception("Product could not be created");
            return ((Product) invocation.getArgument(0)).setId(uuid).setPrice(dummyProduct.getPrice());
        });

        mvc.perform(MockMvcRequestBuilders
                        .post("/products")
                        .content(new ObjectMapper().writeValueAsString(dummyProduct.setId(null)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(uuid.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(dummyProduct.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").doesNotExist());

        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productService, times(1)).save(productArgumentCaptor.capture());
        assertThat(productArgumentCaptor.getValue()).usingRecursiveComparison().isEqualTo(dummyProduct.setId(uuid));
    }

    @Test
    public void updateProduct_requestProductDTOToBeUpdated_expectUpdatedProductDTO() throws Exception {
        String updatedProductName = "updatedProductName";
        given(productService.save(any(Product.class))).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0))) throw new Exception("Product could not be updated");
            return ((Product) invocation.getArgument(0)).setName(updatedProductName);
        });

        mvc.perform(MockMvcRequestBuilders
                        .put("/products")
                        .content(new ObjectMapper().writeValueAsString(dummyProduct))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyProduct.getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(updatedProductName))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").doesNotExist());

        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productService, times(1)).save(productArgumentCaptor.capture());
        assertAll(
                () -> assertThat(productArgumentCaptor.getValue().getId()).isEqualTo(dummyProduct.getId()),
                () -> assertThat(productArgumentCaptor.getValue().getName()).isEqualTo(updatedProductName),
                () -> assertThat(productArgumentCaptor.getValue().getPrice()).isNull()
        );
    }

    @Test
    public void deleteProductById_requestDeletionOfProductById_expectAppropriateState() throws Exception {
        given(productService.deleteById(any(UUID.class))).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0)))
                throw new NoSuchElementException("No such product present");
            return null;
        });

        mvc.perform(MockMvcRequestBuilders
                        .delete("/products/{id}", dummyProduct.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        ArgumentCaptor<UUID> productArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(productService, times(1)).deleteById(productArgumentCaptor.capture());
        assertThat(productArgumentCaptor.getValue()).isEqualTo(dummyProduct.getId());
    }
}
