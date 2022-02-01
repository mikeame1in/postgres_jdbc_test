package com.amelin.jdbctest.model;

public abstract class Entity {
    private Long id;

    public Entity() {
    }

    public Entity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
