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
        TemperatureRule rule = temperatureRuleService.getRuleById(id);
        return ResponseEntity.status(200).body(rule);
    }

    @GetMapping("/product/{productType}")
    public ResponseEntity<TemperatureRule> getRuleForProduct(
            @RequestParam String productType, 
            @RequestParam LocalDate date) {
        TemperatureRule rule = temperatureRuleService.getRuleForProduct(productType, date);
        return ResponseEntity.ok(rule);
    }
        @PutMapping("/{id}")
        public ResponseEntity<TemperatureRule> updateRule(
                    @PathVariable Long id,
                    @RequestBody TemperatureRule rule) {

                TemperatureRule updatedRule = temperatureRuleService.updateRule(id, rule);
                return ResponseEntity.status(200).body(updatedRule);
            }

    @PostMapping
    public ResponseEntity<TemperatureRule> createRule(@RequestBody TemperatureRule rule) {
        return ResponseEntity.status(201).body(temperatureRuleService.createRule(rule));
    }

    @GetMapping
    public List<TemperatureRule> getAllRules() {
        return temperatureRuleService.getAllRules();
    }

       @GetMapping("/active")
        public ResponseEntity<List<TemperatureRule>> getActiveRules() {
            List<TemperatureRule> rules = temperatureRuleService.getActiveRules();
            return ResponseEntity.status(200).body(rules);
        }
}


