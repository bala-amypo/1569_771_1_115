package com.example.demo.entity;

import java.time.LocalDateTime;

public class AlertRecord {
    private long id;
    private long shipmentId;
    private long breachId;
    private String alertType;
    private String message;
    private LocalDateTime sentAt;
    private Boolean acknowledged;

    public AlertRecord(){}

    public AlertRecord(long shipmentId, long breachId, String alertType, String message, LocalDateTime sentAt,
            Boolean acknowledged) {
        this.shipmentId = shipmentId;
        this.breachId = breachId;
        this.alertType = alertType;
        this.message = message;
        this.sentAt = sentAt;
        this.acknowledged = acknowledged;
    }

    public long getId() {
        return id;
    }

    public long getShipmentId() {
        return shipmentId;
    }

    public long getBreachId() {
        return breachId;
    }

    public String getAlertType() {
        return alertType;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public Boolean getAcknowledged() {
        return acknowledged;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setBreachId(long breachId) {
        this.breachId = breachId;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public void setAcknowledged(Boolean acknowledged) {
        this.acknowledged = acknowledged;
    }

    
}
