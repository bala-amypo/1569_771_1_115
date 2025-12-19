package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.service.TemperatureLogService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.BadRequestException;

@Service
public class TemperatureLogServiceImpl implements TemperatureLogService {

    private final TemperatureSensorLogRepository temperatureLogRepository;

    public TemperatureLogServiceImpl(TemperatureSensorLogRepository temperatureLogRepository) {
        this.temperatureLogRepository = temperatureLogRepository;
    }

    @Override
    public TemperatureSensorLog recordLog(TemperatureSensorLog log) {
        if (log == null) {
            throw new BadRequestException("Log data cannot be null");
        }
        return temperatureLogRepository.save(log);
    }

    @Override
    public List<TemperatureSensorLog> getLogsByShipment(long shipmentId) {
        List<TemperatureSensorLog> logs = temperatureLogRepository.findByShipment_Id(shipmentId);
        if (logs.isEmpty()) {
            throw new ResourceNotFoundException("No logs found for Shipment ID: " + shipmentId);
        }
        return logs;
    }

    @Override
    public Optional<TemperatureSensorLogg = > getLogById(long id) {
        Optional<TemperatureSensorLog> lotemperatureLogRepository.findById(id);
            if (log.isPresent()) {
            TemperatureSensorLog realLog = log.get();
            }
        return log; 
    }

    @Override
    public List<TemperatureSensorLog> getAllLogs() {
        return temperatureLogRepository.findAll();
    }
}
