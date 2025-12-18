package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Table(name = "alert_records")
public class AlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_id", nullable = false)
    private Long shipmentId;

    @Column(name = "breach_id", nullable = false)
    private Long breachId;

    @Column(name = "alert_type", nullable = false)
    private String alertType;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "acknowledged", nullable = false)
    private Boolean acknowledged;

    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;

    // No-arg constructor (needed for JPA)
    public AlertRecord() {
    }

    // Parameterized constructor with all the fields
    public AlertRecord(Long shipmentId, Long breachId, String alertType, String message, LocalDateTime sentAt, Boolean acknowledged) {
        this.shipmentId = shipmentId;
        this.breachId = breachId;
        this.alertType = alertType;
        this.message = message;
        this.sentAt = sentAt;
        this.acknowledged = acknowledged;
    }

    // Lifecycle hook - this is called before persisting the entity to the database
    @PrePersist
    private void prePersist() {
        // Default values before persisting
        if (this.acknowledged == null) {
            this.acknowledged = false; // Default to false if not provided
        }
        if (this.sentAt == null) {
            this.sentAt = LocalDateTime.now(); // Set sentAt to current timestamp if not provided
        }
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Long getBreachId() {
        return breachId;
    }

    public void setBreachId(Long breachId) {
        this.breachId = breachId;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(Boolean acknowledged) {
        this.acknowledged = acknowledged;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}