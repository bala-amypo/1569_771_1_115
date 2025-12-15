package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
@Ser
public class ShipmentRecordServiceImpl implements ShipmentRecordService{
    // createShipment(ShipmentRecord shipment);
    // updateShipmentStatus(long id,String status);
    // getShipmentByCode(String code);
    // getShipmentById(long id);
    // getAllShipments(); 
    List<ShipmentRecord> sr = new ArrayList<>();
    int nextShipid=1;
    public ShipmentRecord createShipment(ShipmentRecord shipment){
           shipment.setId(nextShipid);
           nextShipid++;
           sr.add(shipment);
           return shipment;
    }
}
