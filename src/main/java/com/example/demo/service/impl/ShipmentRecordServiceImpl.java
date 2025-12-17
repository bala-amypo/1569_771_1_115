package com.example.demo.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
import com.example.demo.repository.ShipmentRecordRepository;
@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService {

    @Autowired
    private ShipmentRecordRepository shipmentRecordRepository;

    @Override
    public ShipmentRecord createShipment(ShipmentRecord shipment) {
        return shipmentRecordRepository.save(shipment);
    }

    @Override
    public ShipmentRecord updateShipmentStatus(long id, String status) {
        ShipmentRecord shipment = shipmentRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found with id: " + id));

        shipment.setStatus(status);
        return shipmentRecordRepository.save(shipment);
    }

    @Override
    public ShipmentRecord getShipmentByCode(String code) {
        return shipmentRecordRepository.findByShipmentCode(code);
    }

    @Override
    public ShipmentRecord getShipmentById(long id) {
        return shipmentRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found with id: " + id));
    }

    @Override
    public List<ShipmentRecord> getAllShipments() {
        return shipmentRecordRepository.findAll();
    }
}
