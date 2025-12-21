// package com.example.demo.entity;

// import java.time.LocalDateTime;
// import jakarta.persistence.*;
// import jakarta.validation.constraints.NotBlank;
// import com.fasterxml.jackson.annotation.JsonFormat;
// import com.fasterxml.jackson.annotation.JsonIdentityInfo;
// import com.fasterxml.jackson.annotation.JsonIdentityReference;
// import com.fasterxml.jackson.annotation.JsonProperty;
// import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// @Entity
// @Table(name = "breach_records")
// public class BreachRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     // @ManyToOne(fetch = FetchType.EAGER)
//     // @JoinColumn(name = "shipment_id", nullable = false)
//     // @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//     // @JsonIdentityReference(alwaysAsId = true)
//     // private ShipmentRecord shipment;

//     // @OneToOne(fetch = FetchType.EAGER)
//     // @JoinColumn(name = "temperature_log_id", nullable = false)
//     // private TemperatureSensorLog temperatureLog;

//     private String breachType; 
//     private Double breachValue;

//     @NotBlank(message = "Severity is required")
//     @Column(nullable = false)
//     private String severity;

//     private String details;

//     @Column(nullable = false)
//     @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//     private LocalDateTime detectedAt;

//     private Boolean resolved;

//     @JsonProperty("shipmentId")
//     public Long getShipmentIdValue() {
//         return (shipment != null) ? shipment.getId() : null;
//     }

//     @PrePersist
//     public void prePersist() {
//         if (this.detectedAt == null) this.detectedAt = LocalDateTime.now();
//         if (this.resolved == null) this.resolved = false;
//     }

//     // Getters and Setters...
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public ShipmentRecord getShipment() { return shipment; }
//     public void setShipment(ShipmentRecord shipment) { this.shipment = shipment; }
//     public TemperatureSensorLog getTemperatureLog() { return temperatureLog; }
//     public void setTemperatureLog(TemperatureSensorLog temperatureLog) { this.temperatureLog = temperatureLog; }
//     public String getBreachType() { return breachType; }
//     public void setBreachType(String breachType) { this.breachType = breachType; }
//     public Double getBreachValue() { return breachValue; }
//     public void setBreachValue(Double breachValue) { this.breachValue = breachValue; }
//     public String getSeverity() { return severity; }
//     public void setSeverity(String severity) { this.severity = severity; }
//     public String getDetails() { return details; }
//     public void setDetails(String details) { this.details = details; }
//     public LocalDateTime getDetectedAt() { return detectedAt; }
//     public void setDetectedAt(LocalDateTime detectedAt) { this.detectedAt = detectedAt; }
//     public Boolean getResolved() { return resolved; }
//     public void setResolved(Boolean resolved) { this.resolved = resolved; }
// }
package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "breach_record")
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long shipmentId;

    @Column(nullable = false)
    private Long logId;

    @Column(nullable = false)
    private String breachType;

    @Column(nullable = false)
    private Double breachValue;

    @Column(nullable = false)
    private String severity;

    private String details;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime detectedAt;

    @Column(nullable = false)
    private Boolean resolved;

    public BreachRecord() {}

    @PrePersist
    public void prePersist() {
        if (this.detectedAt == null) {
            this.detectedAt = LocalDateTime.now();
        }
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getBreachType() {
        return breachType;
    }

    public void setBreachType(String breachType) {
        this.breachType = breachType;
    }

    public Double getBreachValue() {
        return breachValue;
    }

    public void setBreachValue(Double breachValue) {
        this.breachValue = breachValue;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }
     public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }
}
