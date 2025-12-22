package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/api/temperature-rules")
public class TemperatureRuleController {

    private final TemperatureRuleService temperatureRuleService;

    public TemperatureRuleController(TemperatureRuleService temperatureRuleService) {
        this.temperatureRuleService = temperatureRuleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemperatureRule> getRuleById(@PathVariable Long id) {
        return ResponseEntity.status(200)
                .body(temperatureRuleService.getRuleById(id));
    }

    @GetMapping("/product/{productType}")
    public ResponseEntity<TemperatureRule> getRuleForProduct(
            @PathVariable String productType,
            @RequestParam LocalDate date) {

        return ResponseEntity.status(200)
                .body(temperatureRuleService.getRuleForProduct(productType, date));
    }

    @PostMapping
    public ResponseEntity<TemperatureRule> createRule(@RequestBody TemperatureRule rule) {
        return ResponseEntity.status(201)
                .body(temperatureRuleService.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TemperatureRule> updateRule(
            @PathVariable Long id,
            @RequestBody TemperatureRule rule) {

        return ResponseEntity.status(200)
                .body(temperatureRuleService.updateRule(id, rule));
    }

    @GetMapping("/active")
    public ResponseEntity<List<TemperatureRule>> getActiveRules() {
        return ResponseEntity.status(200)
                .body(temperatureRuleService.getActiveRules());
    }

    @GetMapping
    public ResponseEntity<List<TemperatureRule>> getAllRules() {
        return ResponseEntity.status(200)
                .body(temperatureRuleService.getAllRules());
    }
}