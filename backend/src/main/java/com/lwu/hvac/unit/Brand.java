package com.lwu.hvac.unit;

import java.util.List;

public class Brand {
    private String name;
    private List<Category> categories;

    public Brand() {}

    public Brand(String name, List<Category> categories) {
        this.name = name;
        this.categories = categories;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> categories) { this.categories = categories; }
}
