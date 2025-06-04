package com.lwu.hvac.dto;

public class SearchResult {
    private String type; // "brand", "line", or "variant"
    private String name;
    private String brand;
    private String line;

    // Constructor for brand result
    public SearchResult(String type, String name) {
        this.type = type;
        this.name = name;
    }

    // Constructor for line result
    public SearchResult(String type, String name, String brand) {
        this.type = type;
        this.name = name;
        this.brand = brand;
    }

    // Constructor for variant result
    public SearchResult(String type, String name, String brand, String line) {
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.line = line;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
