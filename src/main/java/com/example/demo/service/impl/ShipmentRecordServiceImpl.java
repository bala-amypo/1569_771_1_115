package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
import com.example.demo.repository.ShipmentRecordRepository;

@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService{

    @Autowired
    private ShipmentRecordRepository shipmentrecordrepository;

    @Override
    public ShipmentRecord createShipment(ShipmentRecord shipment){
           return shipmentrecordrepository.save(shipment);
    }
    @Override
    public ShipmentRecord updateShipmentStatus(long id,String status){
           ShipmentRecord shipment= shipmentrecordrepository.findById(id);
           shipment.setStatus(status);
           return shipmentrecordrepository.save(shipment);
    }
    @Override
    public ShipmentRecord getShipmentByCode(String code){
        return shipmentrecordrepository.findByCode(code);
    }

    @Override 
    public ShipmentRecord getShipmentById(long id){
        return shipmentrecordrepository.findById(id);
    }
    @Override
    public List<ShipmentRecord> getAllShipments(){
        return shipmentrecordrepository.findAll();
    }
}
