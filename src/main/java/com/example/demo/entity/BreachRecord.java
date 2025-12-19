package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "breach_records")
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shipment_id", nullable = false)
    // This stops the JSON from trying to load all logs/breaches inside the shipment
    @JsonIgnoreProperties({"temperatureLogs", "breachRecords", "createdAt"})
    private ShipmentRecord shipment;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "temperature_log_id", nullable = false)
    // This stops the JSON from trying to load the shipment again inside the log
    @JsonIgnoreProperties("shipment")
    private TemperatureSensorLog temperatureLog;

    private String breachType; 
    private Double breachValue;

    @NotBlank(message = "Severity is required")
    @Column(nullable = false)
    private String severity;

    private String details;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime detectedAt;

    private Boolean resolved;

    public BreachRecord() {}

    @PrePersist
    public void prePersist() {
        if (this.detectedAt == null) this.detectedAt = LocalDateTime.now();
        if (this.resolved == null) this.resolved = false;
    }

    // Standard Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ShipmentRecord getShipment() { return shipment; }
    public void setShipment(ShipmentRecord shipment) { this.shipment = shipment; }
    public TemperatureSensorLog getTemperatureLog() { return temperatureLog; }
    public void setTemperatureLog(TemperatureSensorLog temperatureLog) { this.temperatureLog = temperatureLog; }
    public String getBreachType() { return breachType; }
    public void setBreachType(String breachType) { this.breachType = breachType; }
    public Double getBreachValue() { return breachValue; }
    public void setBreachValue(Double breachValue) { this.breachValue = breachValue; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
    public LocalDateTime getDetectedAt() { return detectedAt; }
    public void setDetectedAt(LocalDateTime detectedAt) { this.detectedAt = detectedAt; }
    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}