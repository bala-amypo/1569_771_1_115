package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "shipments")
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_code", nullable = false, unique = true)
    @NotNull
    private String shipmentCode;

    @Column(nullable = false)
    @NotNull
    private String origin;

    @Column(nullable = false)
    @NotNull
    private String destination;

    @Column(nullable = false)
    @NotNull
    private String productType;

    private LocalDateTime startDate;

    private LocalDateTime expectedDelivery;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

   
    @OneToMany(mappedBy = "shipment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TemperatureSensorLog> temperatureLogs;

    @OneToMany(mappedBy = "shipment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BreachRecord> breachRecords;

    public ShipmentRecord() {}

    public ShipmentRecord(String shipmentCode, String origin, String destination,
                          String productType, LocalDateTime startDate,
                          LocalDateTime expectedDelivery) {
        this.shipmentCode = shipmentCode;
        this.origin = origin;
        this.destination = destination;
        this.productType = productType;
        this.startDate = startDate;
        this.expectedDelivery = expectedDelivery;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "IN_TRANSIT"; 
        }
    }

   
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

    public List<TemperatureSensorLog> getTemperatureLogs() {
        return temperatureLogs;
    }

    public List<BreachRecord> getBreachRecords() {
        return breachRecords;
    }

    // Setters
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

    public void setTemperatureLogs(List<TemperatureSensorLog> temperatureLogs) {
        this.temperatureLogs = temperatureLogs;
    }

    public void setBreachRecords(List<BreachRecord> breachRecords) {
        this.breachRecords = breachRecords;
    }
}
