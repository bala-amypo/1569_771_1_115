package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/logs")
@Tag(name = "Temperature Logs")
public class TemperatureLogController {

    @Autowired
    private TemperatureLogService logService;

    @PostMapping
    public ResponseEntity<TemperatureSensorLog> recordLog(@RequestBody TemperatureSensorLog log) {
        TemperatureSensorLog savedLog = logService.recordLog(log);
        
        if (savedLog != null) {
            return ResponseEntity.status(201).body(savedLog);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<TemperatureSensorLog>> getByShipment(@PathVariable Long shipmentId) {
        List<TemperatureSensorLog> logs = logService.getLogsByShipment(shipmentId);
        return ResponseEntity.status(201).body(logs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemperatureSensorLog> getById(@PathVariable Long id) {
        TemperatureSensorLog log = logService.getLogById(id);

        if (log != null) {
            return ResponseEntity.status(201).body(log);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TemperatureSensorLog>> getAll() {
        List<TemperatureSensorLog> list = logService.getAllLogs();
        return ResponseEntity.status(201).body(list);
    }
}