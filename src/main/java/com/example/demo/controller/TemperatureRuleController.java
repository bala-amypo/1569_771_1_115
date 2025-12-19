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

     private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemperatureRule> getRuleById(@PathVariable Long id) {
        TemperatureRule rule = temperatureRuleService.getRuleById(id);
        return ResponseEntity.status(200).body(rule);
    }

    @GetMapping("/search")
    public ResponseEntity<TemperatureRule> getRuleForProduct(
            @RequestParam String productType, 
            @RequestParam LocalDate date) {
        TemperatureRule rule = temperatureRuleService.getRuleForProduct(productType, date);
        return ResponseEntity.ok(rule);
    }

    @PostMapping
    public ResponseEntity<TemperatureRule> createRule(@RequestBody TemperatureRule rule) {
        return ResponseEntity.status(201).body(temperatureRuleService.createRule(rule));
    }

    @GetMapping
    public List<TemperatureRule> getAllRules() {
        return temperatureRuleService.getAllRules();
    }
}