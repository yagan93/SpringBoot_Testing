package com.example.testing.domain.authority.dto;

import com.example.testing.core.generic.ExtendedDTO;
import com.example.testing.domain.role.dto.RoleDTO;
import com.sun.istack.NotNull;

import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AuthorityDTO extends ExtendedDTO {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    public AuthorityDTO() {
    }

    public AuthorityDTO(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AuthorityDTO setName(String name) {
        this.name = name;
        return this;
    }
}
