package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TemperatureRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productType;
    private double minTemp;
    private double maxTemp;
    private String severity;
    private boolean active;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    public TemperatureRule() {}

    // ✅ getters
    public Long getId() { return id; }
    public String getProductType() { return productType; }
    public double getMinTemp() { return minTemp; }
    public double getMaxTemp() { return maxTemp; }
    public String getSeverity() { return severity; }
    public boolean isActive() { return active; } // 🔥 REQUIRED
    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    public LocalDate getEffectiveTo() { return effectiveTo; }

    // ✅ setters
    public void setId(Long id) { this.id = id; }
    public void setProductType(String productType) { this.productType = productType; }
    public void setMinTemp(double minTemp) { this.minTemp = minTemp; }
    public void setMaxTemp(double maxTemp) { this.maxTemp = maxTemp; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setActive(boolean active) { this.active = active; }
    public void setEffectiveFrom(LocalDate effectiveFrom) { this.effectiveFrom = effectiveFrom; }
    public void setEffectiveTo(LocalDate effectiveTo) { this.effectiveTo = effectiveTo; }
}
