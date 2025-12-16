package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService{
//    ShipmentRecord createShipment(ShipmentRecord shipment);
//     ShipmentRecord updateShipmentStatus(long id,String status);
//     ShipmentRecord getShipmentByCode(String code);
//     ShipmentRecord getShipmentById(long id);
//     List<ShipmentRecord> getAllShipments();
    @Autowired
    private ShipmentRecordRepository shipmentrecordrepository;

    @Override
    public ShipmentRecord createShipment(ShipmentRecord shipment){
           
    }
    public ShipmentRecord updateShipmentStatus(long id,String status){
        
    }
}
