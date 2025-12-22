package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.service.TemperatureLogService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemperatureLogServiceImpl implements TemperatureLogService {

    private final TemperatureSensorLogRepository repository;

    public TemperatureLogServiceImpl(TemperatureSensorLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public TemperatureSensorLog recordLog(TemperatureSensorLog log) {
    
        if (log.getShipmentId() == null) {
            throw new ResourceNotFoundException("Shipment ID must be provided");
        }

        if (log.getRecordedAt() == null) {
            log.setRecordedAt(java.time.LocalDateTime.now());
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
