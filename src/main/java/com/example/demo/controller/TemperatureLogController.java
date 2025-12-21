package com.example.demo.controller;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;
import com.example.demo.exception.BadRequestException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class TemperatureLogController {

    private final TemperatureLogService temperatureLogService;

    public TemperatureLogController(TemperatureLogService temperatureLogService) {
        this.temperatureLogService = temperatureLogService;
    }

   @PostMapping
public ResponseEntity<TemperatureSensorLog> recordLog(@RequestBody TemperatureSensorLog log) {
    // validate required fields
    if (log.getShipmentId() == null) {
        throw new BadRequestException("Shipment ID must be provided");
    }
    if (log.getSensorId() == null || log.getSensorId().trim().isEmpty()) {
        throw new BadRequestException("Sensor ID must be provided");
    }
    if (log.getTemperatureValue() == null) {
        throw new BadRequestException("Temperature value must be provided");
    }

    // set recordedAt if missing
    if (log.getRecordedAt() == null) {
        log.setRecordedAt(LocalDateTime.now());
    }

    TemperatureSensorLog savedLog = temperatureLogService.recordLog(log);
    return ResponseEntity.status(201).body(savedLog);
}


    @GetMapping
    public ResponseEntity<List<TemperatureSensorLog>> getAllLogs() {
        List<TemperatureSensorLog> logs = temperatureLogService.getAllLogs();
        return ResponseEntity.status(200).body(logs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemperatureSensorLog> getLogById(@PathVariable Long id) {
        TemperatureSensorLog log = temperatureLogService.getLogById(id)
                .orElseThrow(() -> new BadRequestException("Temperature log not found with ID: " + id));
        return ResponseEntity.status(200).body(log);
    }

    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<TemperatureSensorLog>> getLogsByShipment(@PathVariable Long shipmentId) {
        List<TemperatureSensorLog> logs = temperatureLogService.getLogsByShipment(shipmentId);
        return ResponseEntity.status(200).body(logs);
    }
}
