package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TemperatureRule {

    @Id
    @GeneratedValue
    private Long id;

    private double minTemp;
    private double maxTemp;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    public void setMinTemp(double v) { this.minTemp = v; }
    public void setMaxTemp(double v) { this.maxTemp = v; }
    public void setEffectiveFrom(LocalDate d) { this.effectiveFrom = d; }
    public void setEffectiveTo(LocalDate d) { this.effectiveTo = d; }

    public double getMinTemp() { return minTemp; }
    public double getMaxTemp() { return maxTemp; }
    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    public LocalDate getEffectiveTo() { return effectiveTo; }
}
