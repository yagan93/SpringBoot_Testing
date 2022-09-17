package com.example.testing.domain.ordering;

import com.example.testing.core.generic.ExtendedEntity;
import com.example.testing.domain.orderingposition.OrderingPosition;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Ordering extends ExtendedEntity {

    @OneToMany(
            mappedBy = "ordering",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<OrderingPosition> orderingPositions = new HashSet<>();

    public Ordering() {
    }

    public Ordering(UUID id, Set<OrderingPosition> orderingPositions) {
        super(id);
        this.orderingPositions = orderingPositions;
    }

    public Set<OrderingPosition> getOrderingPositions() {
        return orderingPositions;
    }

    public Ordering setOrderingPositions(Set<OrderingPosition> orderingPositions) {
        this.orderingPositions = orderingPositions;
        return this;
    }
}
