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
        TemperatureSensorLog savedLog = logService.addLog(log);
        return ResponseEntity.status(201).body(savedLog);
    }

    @GetMapping
    public List<TemperatureSensorLog> getAll() {
        return logService.getAllLogs();
    }
}