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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "temperature_logs")
public class TemperatureSensorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", nullable = false)
    private ShipmentRecord shipment;

    @Column(nullable = false)
    private String sensorId;

    @NotNull
    @Column(nullable = false)
    private Double temperatureValue;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime recordedAt;

    @Column(name = "shipment_id")
    private Long shipmentId;

    @Column(name = "location")
    private String location;

    public TemperatureSensorLog() {
    }

    public TemperatureSensorLog(ShipmentRecord shipment,
                          String sensorId,
                          Double temperatureValue,
                          LocalDateTime recordedAt,
                          Long shipmentId,
                          String location) {
        this.shipment = shipment;
        this.sensorId = sensorId;
        this.temperatureValue = temperatureValue;
        this.recordedAt = recordedAt;
        this.shipmentId = shipmentId;
        this.location = location;
    }

    @PrePersist
    public void onCreate() {
        if (this.recordedAt == null) {
            this.recordedAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public ShipmentRecord getShipment() {
        return shipment;
    }

    public String getSensorId() {
        return sensorId;
    }

    public Double getTemperatureValue() {
        return temperatureValue;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setShipment(ShipmentRecord shipment) {
        this.shipment = shipment;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public void setTemperatureValue(Double temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
}
