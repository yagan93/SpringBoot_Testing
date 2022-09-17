package com.example.testing.domain.product.dto;

import com.example.testing.core.generic.ExtendedDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class ProductDTO extends ExtendedDTO {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    public ProductDTO() {
    }

    public ProductDTO(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }
}
