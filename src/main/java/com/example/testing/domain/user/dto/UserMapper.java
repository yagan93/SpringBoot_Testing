package com.example.testing.domain.user.dto;

import com.example.testing.core.generic.ExtendedMapper;
import com.example.testing.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends ExtendedMapper<User, UserDTO> {
    User fromUserRegisterDTO(UserRegisterDTO dto);
}
