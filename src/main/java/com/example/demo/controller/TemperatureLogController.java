package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(201).body(savedLog);
    }

    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<TemperatureSensorLog>> getByShipment(@PathVariable Long shipmentId) {
        List<TemperatureSensorLog> logs = logService.getLogsByShipment(shipmentId);
        return ResponseEntity.ok(logs); // Return 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemperatureSensorLog> getById(@PathVariable Long id) {
        TemperatureSensorLog log = logService.getLogById(id);
        return ResponseEntity.ok(log); // Return 200 OK
    }

    @GetMapping
    public ResponseEntity<List<TemperatureSensorLog>> getAll() {
        List<TemperatureSensorLog> list = logService.getAllLogs();
        return ResponseEntity.ok(list); // Return 200 OK
    }
}