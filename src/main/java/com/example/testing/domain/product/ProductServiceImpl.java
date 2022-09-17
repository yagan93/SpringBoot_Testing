package com.example.testing.domain.product;

import com.example.testing.core.generic.ExtendedRepository;
import com.example.testing.core.generic.ExtendedServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends ExtendedServiceImpl<Product> implements ProductService {

    @Autowired
    public ProductServiceImpl(ExtendedRepository<Product> repository, Logger logger) {
        super(repository, logger);
    }

    // The following method is for testing purposes only
    @Override
    public Integer accumulatedPriceOfAllProducts(List<Product> products) {
        return repository.findAll().stream().map(Product::getPrice).reduce(0, Integer::sum);
    }

    // The following method is for testing purposes only
    @Override
    public Boolean isPriceOfProductAbove(Product product, Integer price) {
        return product.getPrice() > price;
    }
}
