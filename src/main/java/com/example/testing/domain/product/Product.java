package com.example.testing.domain.product;

import com.example.testing.core.generic.ExtendedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Product extends ExtendedEntity {

    @Column(unique = true)
    private String name;

    private Integer price;

    public Product() {
    }

    public Product(UUID id, String name, Integer price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Product setPrice(Integer price) {
        this.price = price;
        return this;
    }
}
