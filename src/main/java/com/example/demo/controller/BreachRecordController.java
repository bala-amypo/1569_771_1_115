package com.example.demo.controller;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/breaches")
public class BreachRecordController {

    private final BreachDetectionService breachService;

    public BreachRecordController(BreachDetectionService breachService) {
        this.breachService = breachService;
    }

    @PostMapping
    public ResponseEntity<BreachRecord> logBreach(@RequestBody BreachRecord breach) {
        return ResponseEntity.status(201).body(breachService.logBreach(breach));
    }

    @GetMapping
    public List<BreachRecord> getAll() {
        return breachService.getAllBreaches();
    }
}