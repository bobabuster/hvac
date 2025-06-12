package com.lwu.hvac.unit;

import java.util.List;

public class Brand {
    private String name;
    private List<ModelTypes> modelTypes;

    public Brand() {}

    public Brand(String name, List<ModelTypes> modelTypes) {
        this.name = name;
        this.modelTypes = modelTypes;
    }

    public String getName() {
        return name;
    }

    public List<ModelTypes> getModelTypes() {
        return modelTypes;
    }
}
