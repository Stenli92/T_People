package com.example.demo.domain.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    private long id;

    public BaseEntity() {
    }

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }


    private void setId(Long id) {
        // Generate a 10-digit ID and set it before persisting the entity
        this.id = id;
    }

    @PrePersist
    private void generate10DigitId() {
        // You can implement your logic here to generate a 10-digit ID
        // For example, using a random number generator or a counter
        // Ensure that the generated ID is unique in your system
        // For simplicity, this example generates a random 10-digit ID
        this.id = (long) (Math.random() * 9_000_000_000L + 1_000_000_000L);
    }
}