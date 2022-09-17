package com.example.testing.domain.ordering.dto;

import com.example.testing.core.generic.ExtendedDTO;
import com.example.testing.domain.orderingposition.dto.OrderingPositionDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

public class OrderingDTO extends ExtendedDTO {

    @NotNull
    @Valid
    private Set<OrderingPositionDTO> orderingPositions;

    public OrderingDTO() {
    }

    public OrderingDTO(UUID id, Set<OrderingPositionDTO> orderingPositions) {
        super(id);
        this.orderingPositions = orderingPositions;
    }

    public Set<OrderingPositionDTO> getOrderingPositions() {
        return orderingPositions;
    }

    public OrderingDTO setOrderingPositions(Set<OrderingPositionDTO> orderingPositions) {
        this.orderingPositions = orderingPositions;
        return this;
    }
}
