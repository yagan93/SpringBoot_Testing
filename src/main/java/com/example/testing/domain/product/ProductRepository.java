package com.example.testing.domain.product;

import com.example.testing.core.generic.ExtendedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ExtendedRepository<Product> {
}
