package com.softserve.edu.entity;

public class Entity {
    private int id;
    private String name;
    private static int counter = 1;

    public Entity(String name) {
        this.id = counter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
