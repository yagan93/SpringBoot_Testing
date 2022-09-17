package com.example.testing.domain.authority.dto;

import com.example.testing.core.generic.ExtendedMapper;
import com.example.testing.domain.authority.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMapper extends ExtendedMapper<Authority, AuthorityDTO> {
}

