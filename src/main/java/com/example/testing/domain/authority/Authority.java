package com.example.testing.domain.authority;

import com.example.testing.core.generic.ExtendedEntity;
import com.example.testing.domain.role.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "authority")
public class Authority extends ExtendedEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public Authority() {
    }

    public Authority(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Authority setName(String name) {
        this.name = name;
        return this;
    }
}
