package com.lwu.hvac.unit;

import java.util.List;

public class Brand {
    private String name;
    private List<ModelLine> modelLines;

    public Brand() {}

    public Brand(String name, List<ModelLine> modelLines) {
        this.name = name;
        this.modelLines = modelLines;
    }

    public String getName() {
        return name;
    }

    public List<ModelLine> getModelLines() {
        return modelLines;
    }
}
