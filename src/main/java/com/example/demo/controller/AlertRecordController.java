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

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
public class AlertRecordController{
    @Autowired 
    AlertService alertservice;

    @PostMapping
    public ResponseEntity<AlertRecord> createShipment(@RequestBody ShipmentRecord shipment){
        ShipmentRecord sh = shipmentrecordservice.createShipment(shipment);
        return ResponseEntity.status(201).body(sh);
    }

    @PutMapping
    public ResponseEntity<AlertRecord> updateStatus(@PathVariable Long id,String status){
        ShipmentRecord sh = shipmentrecordservice.updateShipmentStatus(id,status);
        return ResponseEntity.status(201).body(sh);
    }
    
    @GetMapping("/code/{shipmentCode}")
    public ResponseEntity<AlertRecord> getByCode(@PathVariable String shipmentCode){
        ShipmentRecord sh = shipmentrecordservice.getShipmentByCode(shipmentCode);
        return ResponseEntity.status(201).body(sh);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AlertRecord> getById(@PathVariable Long id){
        ShipmentRecord sh = shipmentrecordservice.getShipmentById(id);
        return ResponseEntity.status(201).body(sh);
    }

    @GetMapping
    public List<AlertRecord> getAll(){
        return shipmentrecordservice.getAllShipments();
    }
}