package com.lwu.hvac.unit;

public class ModelVariant {
    private String name;

    private String url;

    public ModelVariant() {}

    public ModelVariant(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
