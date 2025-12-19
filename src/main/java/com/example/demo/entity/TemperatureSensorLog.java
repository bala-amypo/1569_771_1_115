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

    /* ---------------- Relationships ---------------- */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", nullable = false)
    private ShipmentRecord shipment;

    @Column(nullable = false)
    private String sensorId;

    @NotNull
    @Column(nullable = false)
    private Double temperature;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime recordedAt;

    /* ---------------- Constructors ---------------- */

    public TemperatureSensorLog() {
    }

    public TemperatureSensorLog(ShipmentRecord shipment,
                          String sensorId,
                          Double temperature,
                          LocalDateTime recordedAt) {
        this.shipment = shipment;
        this.sensorId = sensorId;
        this.temperature = temperature;
        this.recordedAt = recordedAt;
    }

    /* ---------------- Lifecycle ---------------- */

    @PrePersist
    protected void onCreate() {
        if (this.recordedAt == null) {
            this.recordedAt = LocalDateTime.now();
        }
    }

    /* ---------------- Getters & Setters ---------------- */

    public Long getId() {
        return id;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public String getSensorId() {
        return sensorId;
    }

    public Double getTemperature() {
        return temperature;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
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

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
}
