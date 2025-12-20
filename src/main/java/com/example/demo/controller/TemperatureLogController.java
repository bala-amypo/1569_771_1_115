package com.example.demo.controller;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class TemperatureLogController {

    private final TemperatureLogService logService;

    public TemperatureLogController(TemperatureLogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<TemperatureSensorLog> createLog(@RequestBody TemperatureSensorLog log) {
        // Calling recordLog to match the Interface definition
        TemperatureSensorLog savedLog = logService.recordLog(log);
        return ResponseEntity.status(201).body(savedLog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemperatureSensorLog> getById(@PathVariable long id) {
        return logService.getLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureSensorLog> getByShipment(@PathVariable long shipmentId) {
        return logService.getLogsByShipment(shipmentId);
    }

    @GetMapping
    public List<TemperatureSensorLog> getAll() {
        return logService.getAllLogs();
    }
}