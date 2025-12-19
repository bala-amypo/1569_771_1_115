package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;

@Service
public interface TemperatureLogService{
    TemperatureSensorLog recordLog(TemperatureSensorLog log);
    List<TemperatureSensorLog> getLogsByShipment(long shipmentId);
    Optional<TemperatureSensorLog> getLogById(long id);
    List<TemperatureSensorLog> getAllLogs();
}