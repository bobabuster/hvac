package com.lwu.hvac.unit;

import java.util.List;

public class ModelTypes {
    private String name;
    private List<ModelVariant> variants;

    public ModelTypes() {}

    public ModelTypes(String name, List<ModelVariant> variants) {
        this.name = name;
        this.variants = variants;
    }

    public String getName() {
        return name;
    }

    public List<ModelVariant> getVariants() {
        return variants;
    }
}
