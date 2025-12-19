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
import jakarta.validation.constraints.NotBlank;
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
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String productType;

    @NotNull
    @Column(nullable = false)
    private Double minTemp;

    @NotNull
    @Column(nullable = false)
    private Double maxTemp;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;

    @NotNull
    @Column(nullable = false)
    private Boolean active;

    /* -------- Fields explicitly INCLUDED as requested -------- */

    private LocalDate effectiveFrom;

    private LocalDate effectiveTo;

    /* ---------------- Constructors ---------------- */

    public TemperatureRule() {
    }

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

    @AssertTrue(message = "minTemperature must be less than maxTemperature")
    private boolean isTemperatureRangeValid() {
        if (minTemp == null || maxTemp == null) {
            return true;
        }
        return minTemp < maxTemp;
    }

    /* ---------------- Getters & Setters ---------------- */

    public Long getId() {
        return id;
    }

    public String getProductType() {
        return productType;
    }

    public Double getMinTemp() {
        return minTemperature;
    }

    public Double getMaxTemp() {
        return maxTemperature;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setMinTemp(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public void setMaxTemp(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
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
