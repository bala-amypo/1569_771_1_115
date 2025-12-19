package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.exception.ResourceNotFoundException; // Added import

@Service
public class TemperatureLogServiceImpl implements TemperatureLogService {

    @Autowired
    private TemperatureSensorLogRepository temperatureLogRepository;

    @Override
    public TemperatureSensorLog recordLog(TemperatureSensorLog log) {
        // You could add a check here for null fields to throw BadRequestException
        if (log == null) {
            throw new com.example.demo.exception.BadRequestException("Log data cannot be null");
        }
        return temperatureLogRepository.save(log);
    }

    @Override
    public List<TemperatureSensorLog> getLogsByShipment(long shipmentId) {
        List<TemperatureSensorLog> logs = temperatureLogRepository.findByShipmentId(shipmentId);
        
        if (logs.isEmpty()) {
            
            throw new ResourceNotFoundException("No logs found for Shipment ID: " + shipmentId);
        }
        return logs;
    }

    @Override
    public TemperatureSensorLog getLogById(long id) {
        
        return temperatureLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Temperature Log not found with ID: " + id));
    }

    @Override
    public List<TemperatureSensorLog> getAllLogs() {
        return temperatureLogRepository.findAll();
    }
}