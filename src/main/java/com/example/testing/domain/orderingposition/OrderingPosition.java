package com.example.testing.domain.orderingposition;

import com.example.testing.core.generic.ExtendedEntity;
import com.example.testing.domain.ordering.Ordering;
import com.example.testing.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class OrderingPosition extends ExtendedEntity {

    @ManyToOne()
    @JoinColumn(name = "ordering_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Ordering ordering;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    private int amount;

    public OrderingPosition() {
    }

    public OrderingPosition(UUID id, Ordering ordering, Product product, int amount) {
        super(id);
        this.ordering = ordering;
        this.product = product;
        this.amount = amount;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public OrderingPosition setOrdering(Ordering ordering) {
        this.ordering = ordering;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public OrderingPosition setProduct(Product product) {
        this.product = product;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public OrderingPosition setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}

