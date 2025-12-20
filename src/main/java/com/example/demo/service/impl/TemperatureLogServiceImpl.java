package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.entity.ShipmentRecord;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.TemperatureLogService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public TemperatureSensorLog recordLog(TemperatureSensorLog log) {
        // Associate the shipment if an ID is provided to prevent nulls in response
        if (log.getShipment() != null && log.getShipment().getId() != null) {
            ShipmentRecord shipment = shipmentRepository.findById(log.getShipment().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found with ID: " + log.getShipment().getId()));
            log.setShipment(shipment);
        }
        return repository.save(log);
    }

    @Override
    public List<TemperatureSensorLog> getLogsByShipment(long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    @Override
    public Optional<TemperatureSensorLog> getLogById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<TemperatureSensorLog> getAllLogs() {
        return repository.findAll();
    }
}