package com.example.testing.core.generic;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class ExtendedEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char") // For testing purposes only. H2 does not support binary UUID.
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    protected ExtendedEntity() {
    }

    protected ExtendedEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public ExtendedEntity setId(UUID id) {
        this.id = id;
        return this;
    }
}