package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ShipmentRecord;

@Service
public interface ShipmentRecordService {
    createShipment(ShipmentRecord shipment);
    updateShipmentStatus(long id,String status);
    getShipmentByCode(String code);
    getShipmentById(long id);
    getAllShipments();
    
}
