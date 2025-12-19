package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "breach_records")
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ Direct ID field for queries
    @Column(name = "shipment_id", insertable = false, updatable = false)
    private Long shipmentId;

    // ✅ Relationship to ShipmentRecord
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", nullable = false)
    private ShipmentRecord shipment;

    // ✅ Relationship to TemperatureSensorLog
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "temperature_log_id", nullable = false)
    private TemperatureSensorLog temperatureLog;

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
                        String breachType,
                        Double breachValue,
                        String severity,
                        String details,
                        LocalDateTime detectedAt,
                        Boolean resolved) {
        this.shipment = shipment;
        this.temperatureLog = temperatureLog;
        this.breachType = breachType;
        this.breachValue = breachValue;
        this.severity = severity;
        this.details = details;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    /* ---------------- Lifecycle ---------------- */
    @PrePersist
    public void onCreate() {
        if (this.detectedAt == null) {
            this.detectedAt = LocalDateTime.now();
        }
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    /* ---------------- Getters ---------------- */
    public Long getId() {
        return id;
    }

    public Long getShipmentId() {
        return (shipment != null) ? shipment.getId() : shipmentId;
    }

    public ShipmentRecord getShipment() {
        return shipment;
    }

    public TemperatureSensorLog getTemperatureLog() {
        return temperatureLog;
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

    /* ---------------- Setters ---------------- */
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
