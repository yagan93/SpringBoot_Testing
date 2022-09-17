package com.example.testing.domain.role.dto;

import com.example.testing.core.generic.ExtendedMapper;
import com.example.testing.domain.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends ExtendedMapper<Role, RoleDTO> {
}
