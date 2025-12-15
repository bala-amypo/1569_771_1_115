package com.example.demo.entity;

import java.time.LocalDateTime;

public class ShipmentRecord {
       private long id;
       private String shipmentCode;
       private String origin;
       private String destination;
       private String productType;
       private LocalDateTime startDate;
       private LocalDateTime expectedDelivery;
       private String status;
       private LocalDateTime createdAt;

    public ShipmentRecord(){}
       
    public ShipmentRecord(String shipmentCode, String origin, String destination, String productType,
            LocalDateTime startDate, LocalDateTime expectedDelivery, String status, LocalDateTime createdAt) {
        this.shipmentCode = shipmentCode;
        this.origin = origin;
        this.destination = destination;
        this.productType = productType;
        this.startDate = startDate;
        this.expectedDelivery = expectedDelivery;
        this.status = status;
        this.createdAt = createdAt;
    }

    public long getId() {
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

    public void setId(long id) {
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