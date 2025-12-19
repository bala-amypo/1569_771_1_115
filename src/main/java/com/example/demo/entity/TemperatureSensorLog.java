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
    private long id;

    /* -------- Relationship required by spec -------- */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", nullable = false)
    private Shipment shipment;

    /* -------- Existing / legacy fields (KEPT) -------- */

    private long shipmentId;

    @Column(nullable = false)
    private String sensorId;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime recordedAt;

    @NotNull
    @Column(nullable = false)
    private Double temperatureValue;

    private String location;

    /* ---------------- Lifecycle ---------------- */

    @PrePersist
    public void setDefaultTime() {
        if (this.recordedAt == null) {
            this.recordedAt = LocalDateTime.now();
        }
    }

    /* ---------------- Constructors ---------------- */

    public TemperatureSensorLog() {
    }

    public TemperatureSensorLog(Shipment shipment,
                                long shipmentId,
                                String sensorId,
                                LocalDateTime recordedAt,
                                Double temperatureValue,
                                String location) {
        this.shipment = shipment;
        this.shipmentId = shipmentId;
        this.sensorId = sensorId;
        this.recordedAt = recordedAt;
        this.temperatureValue = temperatureValue;
        this.location = location;
    }

    /* ---------------- Getters & Setters ---------------- */

    public long getId() {
        return id;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public long getShipmentId() {
        return shipmentId;
    }

    public String getSensorId() {
        return sensorId;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public Double getTemperatureValue() {
        return temperatureValue;
    }

    public String getLocation() {
        return location;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public void setTemperatureValue(Double temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
