package com.example.testing.domain.orderingposition.dto;

import com.example.testing.core.generic.ExtendedDTO;
import com.example.testing.domain.product.dto.ProductDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class OrderingPositionDTO extends ExtendedDTO {

    @NotNull
    @Valid
    private ProductDTO product;

    @NotNull
    private int amount;

    public OrderingPositionDTO() {
    }

    public OrderingPositionDTO(UUID id, ProductDTO product, int amount) {
        super(id);
        this.product = product;
        this.amount = amount;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public OrderingPositionDTO setProduct(ProductDTO product) {
        this.product = product;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public OrderingPositionDTO setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
