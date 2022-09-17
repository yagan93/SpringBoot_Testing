package com.example.testing.domain.ordering.dto;

import com.example.testing.core.generic.ExtendedMapper;
import com.example.testing.domain.ordering.Ordering;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderingMapper extends ExtendedMapper<Ordering, OrderingDTO> {
}

