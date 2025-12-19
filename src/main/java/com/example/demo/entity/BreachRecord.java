package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
@Entity
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long shipmentId;
    private long logId;
    private String breachType;
    private Double breachValue;
    private String severity;
    private String details;
    private LocalDateTime detectedAt;
    private Boolean resolved;

    public BreachRecord(){}

    public BreachRecord(long shipmentId, long logId, String breachType, Double breachValue, String severity,
            String details, LocalDateTime detectedAt, Boolean resolved) {
        this.shipmentId = shipmentId;
        this.logId = logId;
        this.breachType = breachType;
        this.breachValue = breachValue;
        this.severity = severity;
        this.details = details;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    public long getId() {
        return id;
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


@PrePersist
    public void prePersist() {
        if (this.detectedAt == null) {
            this.detectedAt = LocalDateTime.now();
        }
        if (this.resolved == null) {
            this.resolved = false;
        }
    }
} 