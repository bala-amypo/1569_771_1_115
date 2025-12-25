package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TemperatureRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productType;
    private Double minTemp;
    private Double maxTemp;
    private String severity;
    private Boolean active;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    // ===== GETTERS (REQUIRED) =====
    public Long getId() {
        return id;
    }

    public String getProductType() {      // 🔴 missing before
        return productType;
    }

    public Double getMinTemp() {           // 🔴 missing before
        return minTemp;
    }

    public Double getMaxTemp() {           // 🔴 missing before
        return maxTemp;
    }

    public String getSeverity() {          // 🔴 missing before
        return severity;
    }

    public Boolean getActive() {           // 🔴 missing before
        return active;
    }

    public LocalDate getEffectiveFrom() {  // 🔴 missing before
        return effectiveFrom;
    }

    public LocalDate getEffectiveTo() {    // 🔴 missing before
        return effectiveTo;
    }

    // ===== SETTERS =====
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setEffectiveFrom(LocalDate effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public void setEffectiveTo(LocalDate effectiveTo) {
        this.effectiveTo = effectiveTo;
    }
}
