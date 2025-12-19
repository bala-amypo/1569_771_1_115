package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "shipments")
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "shipment_code", nullable = false, unique = true)
    private String shipmentCode;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @NotBlank
    @Column(nullable = false)
    private String productType;

    // Fields explicitly requested to keep
    private LocalDateTime startDate;

    private LocalDateTime expectedDelivery;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /* ---------------- Relationships ---------------- */

    @OneToMany(
        mappedBy = "shipment",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<TemperatureLog> temperatureLogs;

    @OneToMany(
        mappedBy = "shipment",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<BreachRecord> breachRecords;

    /* ---------------- Constructors ---------------- */

    public Shipment() {
    }

    public Shipment(String shipmentCode,
                    String origin,
                    String destination,
                    String productType,
                    LocalDateTime startDate,
                    LocalDateTime expectedDelivery,
                    String status) {
        this.shipmentCode = shipmentCode;
        this.origin = origin;
        this.destination = destination;
        this.productType = productType;
        this.startDate = startDate;
        this.expectedDelivery = expectedDelivery;
        this.status = status;
    }

    /* ---------------- Lifecycle ---------------- */

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "IN_TRANSIT";
        }
    }

    /* ---------------- Getters & Setters ---------------- */

    public Long getId() {
        return id;
    }

    public String getShipmentCode() {
        return shipmentCode;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getProductType() {
        return productType;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getExpectedDelivery() {
        return expectedDelivery;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<TemperatureLog> getTemperatureLogs() {
        return temperatureLogs;
    }

    public List<BreachRecord> getBreachRecords() {
        return breachRecords;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setShipmentCode(String shipmentCode) {
        this.shipmentCode = shipmentCode;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setExpectedDelivery(LocalDateTime expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
