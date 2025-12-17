package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ShipmentRecord createShipment(@RequestBody ShipmentRecord shipment){
        return shipmentrecordservice.createShipment(shipment);
    }

    @PutMapping
    public ShipmentRecord updateStatus(@PathVariable Long id,String status){
        return shipmentrecordservice.updateShipmentStatus(id,status);
    }
    
    @GetMapping("/code/{shipmentCode}")
    public ShipmentRecord getByCode(@PathVariable String shipmentCode){
        return shipmentrecordservice.getShipmentByCode(shipmentCode);
    }
    
    @GetMapping("/{id}")
    public ShipmentRecord getById(@PathVariable Long id){
        return shipmentrecordservice.getShipmentById(id);
    }

    @GetMapping
    public List<ShipmentRecord> getAll(){
        return shipmentrecordservice.getAllShipments();
    }
}
