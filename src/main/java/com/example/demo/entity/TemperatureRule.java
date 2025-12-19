package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(
    name = "temperature_rules",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = { "productType", "active" })
    }
)
public class TemperatureRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String productType;

    private Double minTemp;

    private Double maxTemp;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;   // LOW / MEDIUM / HIGH

    private Boolean active;

    // --- Existing fields kept as-is ---
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    /* ---------------- Constructors ---------------- */

    public TemperatureRule() {}

    public TemperatureRule(String productType,
                           Double minTemp,
                           Double maxTemp,
                           Severity severity,
                           Boolean active,
                           LocalDate effectiveFrom,
                           LocalDate effectiveTo) {
        this.productType = productType;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.severity = severity;
        this.active = active;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTo = effectiveTo;
    }

    /* ---------------- Validation ---------------- */

    @AssertTrue(message = "minTemp must be less than maxTemp")
    private boolean isTemperatureRangeValid() {
        if (minTemp == null || maxTemp == null) {
            return true;
        }
        return minTemp < maxTemp;
    }

    /* ---------------- Getters & Setters ---------------- */

    public long getId() {
        return id;
    }

    public String getProductType() {
        return productType;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public Severity getSeverity() {
        return severity;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDate getEffectiveFrom() {
        return effectiveFrom;
    }

    public LocalDate getEffectiveTo() {
        return effectiveTo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setSeverity(Severity severity) {
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
