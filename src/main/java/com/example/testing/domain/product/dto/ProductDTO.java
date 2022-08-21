package com.example.testing.domain.product.dto;

import java.util.UUID;

public class ProductDTO {
    private UUID id;
    private String name;

    public ProductDTO() {
    }

    public ProductDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public ProductDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }
}
