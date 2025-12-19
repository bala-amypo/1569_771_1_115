package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/breaches")
@Tag(name = "Breach-record-controller")
public class BreachRecordController {

   @RestController
public class BreachDetectionController {

    private final BreachDetectionService breachService;

    public BreachDetectionController(BreachDetectionService breachService) {
        this.breachService= breachService;
    }
}


    @PostMapping
    public ResponseEntity<BreachRecord> logBreach(@RequestBody BreachRecord breach) {
        BreachRecord savedBreach = breachService.logBreach(breach);

        if (savedBreach != null) {
            return ResponseEntity.status(201).body(savedBreach);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<BreachRecord> resolveBreach(@PathVariable Long id) {
        BreachRecord breach = breachService.getBreachById(id);

        if (breach != null) {
            BreachRecord resolvedBreach = breachService.resolveBreach(id);
            return ResponseEntity.status(200).body(resolvedBreach);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<BreachRecord>> getBreachesByShipment(@PathVariable Long shipmentId) {
        List<BreachRecord> breaches = breachService.getBreachesByShipment(shipmentId);

        if (breaches != null && !breaches.isEmpty()) {
            return ResponseEntity.status(200).body(breaches);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<BreachRecord> getBreachById(@PathVariable Long id) {
        BreachRecord breach = breachService.getBreachById(id);

        if (breach != null) {
            return ResponseEntity.status(200).body(breach);
        } else {
            return ResponseEntity.status(404).build();
        }
    }


    @GetMapping
    public ResponseEntity<List<BreachRecord>> getAllBreaches() {
        List<BreachRecord> breaches = breachService.getAllBreaches();

        if (breaches != null && !breaches.isEmpty()) {
            return ResponseEntity.status(200).body(breaches);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
