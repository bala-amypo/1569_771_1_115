// package com.example.demo.entity;

// import java.time.LocalDateTime;
// import java.util.List;
// import jakarta.persistence.*;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @Entity
// @Table(name = "shipments")
// public class ShipmentRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String shipmentCode;

//     private String productType;
//     private String status;

//     // @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
//     // @JsonIgnoreProperties("shipment")
//     // private List<TemperatureSensorLog> temperatureLogs;

//     // @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
//     // @JsonIgnoreProperties("shipment")
//     // private List<BreachRecord> breachRecords;

//     // Standard Getters/Setters/Constructors...
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getShipmentCode() { return shipmentCode; }
//     public void setShipmentCode(String shipmentCode) { this.shipmentCode = shipmentCode; }
//     public String getProductType() { return productType; }
//     public void setProductType(String productType) { this.productType = productType; }
//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }
// }

package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(
    name = "shipment_record",
    uniqueConstraints = @UniqueConstraint(columnNames = "shipment_code")
)
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_code", nullable = false, unique = true)
    private String shipmentCode;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private String productType;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime expectedDelivery;

    @Column(nullable = false)
    private String status;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Relationships
    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("shipment")
    private List<TemperatureSensorLog> temperatureLogs;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("shipment")
    private List<BreachRecord> breachRecords;

    public ShipmentRecord() {}

    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            this.status = "IN_TRANSIT";
        }
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getShipmentCode() { return shipmentCode; }
    public void setShipmentCode(String shipmentCode) { this.shipmentCode = shipmentCode; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }

    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getExpectedDelivery() { return expectedDelivery; }
    public void setExpectedDelivery(LocalDateTime expectedDelivery) { this.expectedDelivery = expectedDelivery; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<TemperatureSensorLog> getTemperatureLogs() { return temperatureLogs; }
    public void setTemperatureLogs(List<TemperatureSensorLog> temperatureLogs) { this.temperatureLogs = temperatureLogs; }

    public List<BreachRecord> getBreachRecords() { return breachRecords; }
    public void setBreachRecords(List<BreachRecord> breachRecords) { this.breachRecords = breachRecords; }
}
