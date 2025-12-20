package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.entity.ShipmentRecord;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.TemperatureLogService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TemperatureLogServiceImpl implements TemperatureLogService {

    private final TemperatureSensorLogRepository repository;
    private final ShipmentRecordRepository shipmentRepository;

    public TemperatureLogServiceImpl(TemperatureSensorLogRepository repository, 
                                     ShipmentRecordRepository shipmentRepository) {
        this.repository = repository;
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public TemperatureSensorLog addLog(TemperatureSensorLog log) {
        // If the JSON sent "shipment": 1, we fetch the real shipment to populate the response
        if (log.getShipment() != null && log.getShipment().getId() != null) {
            ShipmentRecord shipment = shipmentRepository.findById(log.getShipment().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found with ID: " + log.getShipment().getId()));
            log.setShipment(shipment);
        }
        return repository.save(log);
    }

    @Override
    public List<TemperatureSensorLog> getLogsByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    @Override
    public List<TemperatureSensorLog> getAllLogs() {
        return repository.findAll();
    }
}