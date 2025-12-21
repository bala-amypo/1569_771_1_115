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

    // ===== 1. POST /api/breaches =====
    // Log a manual breach → 201
    @PostMapping
    public ResponseEntity<BreachRecord> logBreach(@RequestBody BreachRecord breach) {
        BreachRecord savedBreach = breachService.logBreach(breach);
        return ResponseEntity.status(201).body(savedBreach);
    }

    // ===== 2. PUT /api/breaches/{id}/resolve =====
    // Resolve a breach → 200
    @PutMapping("/{id}/resolve")
    public ResponseEntity<BreachRecord> resolveBreach(@PathVariable Long id) {
        BreachRecord resolvedBreach = breachService.resolveBreach(id);
        return ResponseEntity.status(200).body(resolvedBreach);
    }

    // ===== 3. GET /api/breaches/shipment/{shipmentId} =====
    // Get breaches by shipment → 200
    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<BreachRecord>> getBreachesByShipment(@PathVariable Long shipmentId) {
        List<BreachRecord> breaches = breachService.getBreachesByShipment(shipmentId);
        return ResponseEntity.status(200).body(breaches);
    }

    // ===== 4. GET /api/breaches/{id} =====
    // Get breach by ID → 200
    @GetMapping("/{id}")
    public ResponseEntity<BreachRecord> getBreachById(@PathVariable Long id) {
        BreachRecord breach = breachService.getBreachById(id);
        return ResponseEntity.status(200).body(breach);
    }

    // ===== 5. GET /api/breaches =====
    // List all breaches → 200
    @GetMapping
    public ResponseEntity<List<BreachRecord>> getAllBreaches() {
        List<BreachRecord> allBreaches = breachService.getAllBreaches();
        return ResponseEntity.status(200).body(allBreaches);
    }
}
