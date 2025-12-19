package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "breach_records")
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_id", insertable = false, updatable = false)
    private Long shipmentId; 

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private ShipmentRecord shipment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "temperature_log_id", nullable = false)
    private TemperatureSensorLog temperatureLog;

    private Long shipmentId;

    private Long logId;

    private String breachType;

    @Column(nullable = false)
    private Double breachValue;

    @NotNull
    @Column(nullable = false)
    private String severity;

    private String details;

    @Column(nullable = false)
    private LocalDateTime detectedAt;

    private Boolean resolved;

    public BreachRecord() {
    }

    public BreachRecord(ShipmentRecord shipment,
                        TemperatureSensorLog temperatureLog,
                        Long shipmentId,
                        Long logId,
                        String breachType,
                        Double breachValue,
                        String severity,
                        String details,
                        LocalDateTime detectedAt,
                        Boolean resolved) {
        this.shipment = shipment;
        this.temperatureLog = temperatureLog;
        this.shipmentId = shipmentId;
        this.logId = logId;
        this.breachType = breachType;
        this.breachValue = breachValue;
        this.severity = severity;
        this.details = details;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    /* ---------------- Lifecycle ---------------- */

    @PrePersist
    protected void onCreate() {
        if (this.detectedAt == null) {
            this.detectedAt = LocalDateTime.now();
        }
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    /* ---------------- Getters & Setters ---------------- */

    public Long getId() {
        return id;
    }

    public ShipmentRecord getShipment() {
        return shipment;
    }

    public TemperatureSensorLog getTemperatureLog() {
        return temperatureLog;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public Long getLogId() {
        return logId;
    }

    public String getBreachType() {
        return breachType;
    }

    public Double getBreachValue() {
        return breachValue;
    }

    public String getSeverity() {
        return severity;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setShipment(ShipmentRecord shipment) {
        this.shipment = shipment;
    }

    public void setTemperatureLog(TemperatureSensorLog temperatureLog) {
        this.temperatureLog = temperatureLog;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public void setBreachType(String breachType) {
        this.breachType = breachType;
    }

    public void setBreachValue(Double breachValue) {
        this.breachValue = breachValue;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
