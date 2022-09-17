package com.example.testing.domain.product;

import com.example.testing.core.generic.ExtendedService;

import java.util.List;

public interface ProductService extends ExtendedService<Product> {

    Integer accumulatedPriceOfAllProducts(List<Product> products);

    Boolean isPriceOfProductAbove(Product product, Integer integer);
}
