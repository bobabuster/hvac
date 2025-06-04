package com.lwu.hvac.unit;

public class Model {
    private String name;
    private String voltage;
    private String phase;
    private String manualUrl;  // URL/path to the user manual

    public Model() {}

    public Model(String name, String voltage, String phase, String manualUrl) {
        this.name = name;
        this.voltage = voltage;
        this.phase = phase;
        this.manualUrl = manualUrl;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getVoltage() { return voltage; }
    public void setVoltage(String voltage) { this.voltage = voltage; }

    public String getPhase() { return phase; }
    public void setPhase(String phase) { this.phase = phase; }

    public String getManualUrl() { return manualUrl; }
    public void setManualUrl(String manualUrl) { this.manualUrl = manualUrl; }
}
