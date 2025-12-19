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
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "breach_records")
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /* ----------- Spec Relationships ----------- */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", nullable = false)
    private Shipment shipment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "temperature_log_id", nullable = false)
    private TemperatureLog temperatureLog;

    /* ----------- Existing Fields (NOT REMOVED) ----------- */

    private long shipmentId;     // retained
    private long logId;          // retained
    private String breachType;   // retained

    private Double breachValue;

    @NotBlank
    @Column(nullable = false)
    private String severity;

    private String details;      // retained

    @Column(nullable = false)
    private LocalDateTime detectedAt;

    private Boolean resolved;    // retained

    /* ----------- Constructors ----------- */

    public BreachRecord() {}

    public BreachRecord(long shipmentId,
                        long logId,
                        String breachType,
                        Double breachValue,
                        String severity,
                        String details,
                        LocalDateTime detectedAt,
                        Boolean resolved) {
        this.shipmentId = shipmentId;
        this.logId = logId;
        this.breachType = breachType;
        this.breachValue = breachValue;
        this.severity = severity;
        this.details = details;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    /* ----------- Lifecycle ----------- */

    @PrePersist
    public void prePersist() {
        if (this.detectedAt == null) {
            this.detectedAt = LocalDateTime.now();
        }
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    /* ----------- Getters & Setters ----------- */

    public long getId() {
        return id;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public TemperatureLog getTemperatureLog() {
        return temperatureLog;
    }

    public long getShipmentId() {
        return shipmentId;
    }

    public long getLogId() {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public void setTemperatureLog(TemperatureLog temperatureLog) {
        this.temperatureLog = temperatureLog;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setLogId(long logId) {
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
