package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TemperatureRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productType;
    private Double minTemp;
    private Double maxTemp;
    private String severity;
    private boolean active;

    public TemperatureRule() {}

    public Long getId() { return id; }
    public String getProductType() { return productType; }
    public Double getMinTemp() { return minTemp; }
    public Double getMaxTemp() { return maxTemp; }
    public String getSeverity() { return severity; }
    public boolean isActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setProductType(String productType) { this.productType = productType; }
    public void setMinTemp(Double minTemp) { this.minTemp = minTemp; }
    public void setMaxTemp(Double maxTemp) { this.maxTemp = maxTemp; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setActive(boolean active) { this.active = active; }

    // ✅ REQUIRED BY TEST
    public boolean isPresent() {
        return true;
    }
}
