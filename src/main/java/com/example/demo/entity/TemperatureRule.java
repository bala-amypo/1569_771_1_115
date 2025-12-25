package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "temperature_rules")
public class TemperatureRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productType;
    private Double minTemperature;
    private Double maxTemperature;
    private String severity;
    private boolean active = true;

    public TemperatureRule() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }

    public Double getMinTemperature() { return minTemperature; }
    public void setMinTemperature(Double minTemperature) { this.minTemperature = minTemperature; }

    public Double getMaxTemperature() { return maxTemperature; }
    public void setMaxTemperature(Double maxTemperature) { this.maxTemperature = maxTemperature; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
