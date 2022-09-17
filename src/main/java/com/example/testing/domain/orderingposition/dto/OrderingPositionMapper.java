package com.example.testing.domain.orderingposition.dto;

import com.example.testing.core.generic.ExtendedMapper;
import com.example.testing.domain.orderingposition.OrderingPosition;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderingPositionMapper extends ExtendedMapper<OrderingPosition, OrderingPositionDTO> {
}

