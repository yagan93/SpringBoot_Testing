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

    private Set<RoleDTO> roles = new HashSet<>();

    public AuthorityDTO() {
    }

    public AuthorityDTO(UUID id, String name, Set<RoleDTO> roles) {
        super(id);
        this.name = name;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public AuthorityDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public AuthorityDTO setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
        return this;
    }
}
