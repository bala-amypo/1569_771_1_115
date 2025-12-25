package com.example.demo.controller;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class TemperatureLogController {

    private final TemperatureLogService temperatureLogService;

    public TemperatureLogController(TemperatureLogService temperatureLogService) {
        this.temperatureLogService = temperatureLogService;
    }

    @PostMapping
    public ResponseEntity<TemperatureSensorLog> recordLog(
            @RequestBody TemperatureSensorLog log) {

        return ResponseEntity.ok(
                temperatureLogService.recordLog(log)
        );
    }

    @GetMapping
    public ResponseEntity<List<TemperatureSensorLog>> getAllLogs() {
        return ResponseEntity.ok(
                temperatureLogService.getAllLogs()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemperatureSensorLog> getLogById(
            @PathVariable Long id) {

        TemperatureSensorLog log =
                temperatureLogService.getLogById(id);

        if (log == null) {
            return ResponseEntity.badRequest().build(); // ✅ FIX
        }

        return ResponseEntity.ok(log);
    }
}
