package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ShipmentRecord;

@Service
public interface ShipmentRecordService {
    ShipmentRecord createShipment(ShipmentRecord shipment);
    ShipmentRecord updateShipmentStatus(long id,String status);
    ShipmentRecord getShipmentByCode(String code);
    ShipmentRecord getShipmentById(long id);
    List<ShipmentRecord> getAllShipments();
    
}

