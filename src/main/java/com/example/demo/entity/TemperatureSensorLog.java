// package com.example.demo.entity;

// import java.time.LocalDateTime;
// import jakarta.persistence.*;
// import jakarta.validation.constraints.NotNull;
// import com.fasterxml.jackson.annotation.JsonFormat;
// import com.fasterxml.jackson.annotation.JsonIdentityInfo;
// import com.fasterxml.jackson.annotation.JsonIdentityReference;
// import com.fasterxml.jackson.annotation.JsonProperty;
// import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// @Entity
// @Table(name = "temperature_logs")
// public class TemperatureSensorLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     // @ManyToOne(fetch = FetchType.EAGER)
//     // @JoinColumn(name = "shipment_id")
//     // @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//     // @JsonIdentityReference(alwaysAsId = true)
//     private ShipmentRecord shipment;

//     @Column(nullable = false)
//     private String sensorId;

//     @NotNull
//     @Column(nullable = false)
//     @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//     private LocalDateTime recordedAt;

//     @NotNull
//     @Column(nullable = false)
//     private Double temperatureValue;

//     private String location;

//     // This ensures "shipmentId" is visible in the JSON response even if the object is hidden
//     @JsonProperty("shipmentId")
//     public Long getShipmentIdValue() {
//         return (shipment != null) ? shipment.getId() : null;
//     }

//     public TemperatureSensorLog() {}

//     @PrePersist
//     public void setDefaultTime() {
//         if (this.recordedAt == null) {
//             this.recordedAt = LocalDateTime.now();
//         }
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public ShipmentRecord getShipment() { return shipment; }
//     public void setShipment(ShipmentRecord shipment) { this.shipment = shipment; }
//     public String getSensorId() { return sensorId; }
//     public void setSensorId(String sensorId) { this.sensorId = sensorId; }
//     public LocalDateTime getRecordedAt() { return recordedAt; }
//     public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }
//     public Double getTemperatureValue() { return temperatureValue; }
//     public void setTemperatureValue(Double temperatureValue) { this.temperatureValue = temperatureValue; }
//     public String getLocation() { return location; }
//     public void setLocation(String location) { this.location = location; }
// }
package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "temperature_sensor_log")
public class TemperatureSensorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Simple FK reference (no JPA relationship)
    @NotNull
    @Column(name = "shipment_id", nullable = false)
    private Long shipmentId;

    @NotNull
    @Column(nullable = false)
    private String sensorId;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime recordedAt;

    @NotNull
    @Column(nullable = false)
    private Double temperatureValue;

    // Optional field
    private String location;

    public TemperatureSensorLog() {}

    @PrePersist
    public void prePersist() {
        if (this.recordedAt == null) {
            this.recordedAt = LocalDateTime.now();
        }
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public Double getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(Double temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
