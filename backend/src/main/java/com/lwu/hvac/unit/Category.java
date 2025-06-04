package com.lwu.hvac.unit;

import java.util.List;

public class Category {
    private String name;
    private List<Model> models;

    public Category() {}

    public Category(String name, List<Model> models) {
        this.name = name;
        this.models = models;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Model> getModels() { return models; }
    public void setModels(List<Model> models) { this.models = models; }
}
