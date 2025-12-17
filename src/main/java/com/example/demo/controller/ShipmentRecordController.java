package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentRecordController{
    @Autowired 
    ShipmentRecordService shipmentrecordservice;

    @PostMapping
    public ResponseEntity<ShipmentRecord> createShipment(@RequestBody ShipmentRecord shipment){
        ShipmentRecord sh = shipmentrecordservice.createShipment(shipment);
        return ResponseEntity.status(201).body(sh);
    }

    @PutMapping
    public ResponseEntity<ShipmentRecord> updateStatus(@PathVariable Long id,String status){
        ShipmentRecord sh = shipmentrecordservice.updateShipmentStatus(id,status);
        return ResponseEntity.status(201).body(
    }
    
    @GetMapping("/code/{shipmentCode}")
    public ResponseEntity<ShipmentRecord> getByCode(@PathVariable String shipmentCode){
        return shipmentrecordservice.getShipmentByCode(shipmentCode);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ShipmentRecord> getById(@PathVariable Long id){
        return shipmentrecordservice.getShipmentById(id);
    }

    @GetMapping
    public List<ShipmentRecord> getAll(){
        return shipmentrecordservice.getAllShipments();
    }
}