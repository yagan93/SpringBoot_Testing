package com.example.testing.domain.product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> findAll();

    Product findById(UUID id);

    Product save(Product product);

    Void deleteById(UUID id);

    Integer accumulatedPriceOfAllProducts(List<Product> products);

    Boolean isPriceOfProductAbove(Product product, Integer integer);
}
