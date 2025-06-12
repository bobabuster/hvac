package com.lwu.hvac.unit;

import java.util.List;

public class ModelLine {
    private String name;
    private List<ModelVariant> variants;

    public ModelLine() {}

    public ModelLine(String name, List<ModelVariant> variants) {
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
