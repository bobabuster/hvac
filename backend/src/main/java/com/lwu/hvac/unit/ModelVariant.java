package com.lwu.hvac.unit;

public class ModelVariant {
    private String name;
    private String voltage;
    private String phase;
    private String url;

    public ModelVariant() {}

    public ModelVariant(String name, String voltage, String phase, String url) {
        this.name = name;
        this.voltage = voltage;
        this.phase = phase;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getVoltage() {
        return voltage;
    }

    public String getPhase() {
        return phase;
    }

    public String getUrl() {
        return url;
    }
}
