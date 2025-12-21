package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "shipments")
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String shipmentCode;

    private String productType;
    private String status;

    // @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    // @JsonIgnoreProperties("shipment")
    // private List<TemperatureSensorLog> temperatureLogs;

    // @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    // @JsonIgnoreProperties("shipment")
    // private List<BreachRecord> breachRecords;

    // Standard Getters/Setters/Constructors...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getShipmentCode() { return shipmentCode; }
    public void setShipmentCode(String shipmentCode) { this.shipmentCode = shipmentCode; }
    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}