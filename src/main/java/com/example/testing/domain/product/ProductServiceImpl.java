package com.example.testing.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(UUID id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No such product present");
        }
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Void deleteById(UUID id) throws NoSuchElementException {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("No such product present");
        }
        return null;
    }

    // The following method is for testing purposes only
    @Override
    public Integer accumulatedPriceOfAllProducts(List<Product> products) {
        return productRepository.findAll().stream().map(Product::getPrice).reduce(0, Integer::sum);
    }

    // The following method is for testing purposes only
    @Override
    public Boolean isPriceOfProductAbove(Product product, Integer price) {
        return product.getPrice() > price;
    }


}
