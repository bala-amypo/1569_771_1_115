package com.example.demo.entity;

import java.time.LocalDateTime;

public class TemperatureSensorLog {
    private long id;
    private long shipmentId;
    private String sensorId;
    private LocalDateTime recordedAt;
    private Double temperatureValue;
    private String location;

    public TemperatureSensorLog(){}

    public TemperatureSensorLog(long shipmentId, String sensorId, LocalDateTime recordedAt, Double temperatureValue,
            String location) {
        this.shipmentId = shipmentId;
        this.sensorId = sensorId;
        this.recordedAt = recordedAt;
        this.temperatureValue = temperatureValue;
        this.location = location;
    }

    public long getId() {
        return id;
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
