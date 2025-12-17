package com.example.demo1.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo1.entity.TemperatureSensorLog;
import com.example.demo1.service.TemperatureLogService;
import com.example.demo1.repository.TemperatureSensorLogRepository;

@Service
public class TemperatureLogServiceImpl implements TemperatureLogService {

    @Autowired
    TemperatureSensorLogRepository temperatureLogRepository;

    @Override
    public TemperatureSensorLog recordLog(TemperatureSensorLog log) {
        return temperatureLogRepository.save(log);
    }

    @Override
    public List<TemperatureSensorLog> getLogsByShipment(long shipmentId) {
        List<TemperatureSensorLog> logs = temperatureLogRepository.findByShipmentId(shipmentId);
        
        if (logs.isEmpty()) {
            throw new RuntimeException("No logs found for Shipment ID: " + shipmentId);
        }
        return logs;
    }

    @Override
    public TemperatureSensorLog getLogById(long id) {
        return temperatureLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Temperature Log not found with ID: " + id));
    }

    @Override
    public List<TemperatureSensorLog> getAllLogs() {
        return temperatureLogRepository.findAll();
    }
}