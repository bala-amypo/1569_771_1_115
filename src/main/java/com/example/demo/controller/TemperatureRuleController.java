package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rules")
public class TemperatureRuleController {

    @Autowired
    TemperatureRuleService temperatureRuleService;

   
    @GetMapping
    public List<TemperatureRule> getAllRules() {
        return temperatureRuleService.getAllRules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemperatureRule> getRuleById(@PathVariable Long id) {

        Optional<TemperatureRule> rule =
                temperatureRuleService.getRuleById(id);

        if (rule.isPresent()) {
            return ResponseEntity.status(200).body(rule.get());
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<TemperatureRule> createRule(
            @RequestBody TemperatureRule temperatureRule) {

        TemperatureRule savedRule =
                temperatureRuleService.createRule(temperatureRule);

        if (savedRule != null) {
            return ResponseEntity.status(201).body(savedRule);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TemperatureRule> updateRule(
            @PathVariable Long id,
            @RequestBody TemperatureRule temperatureRule) {

        TemperatureRule updatedRule =
                temperatureRuleService.updateRule(id, temperatureRule);

        if (updatedRule != null) {
            return ResponseEntity.status(200).body(updatedRule);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActiveRules() {
        return temperatureRuleService.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    public ResponseEntity<TemperatureRule> getRuleForProduct(
            @PathVariable String productType,
            LocalDate date) {

        if (date == null) {
            date = LocalDate.now();
        }

        TemperatureRule rule = temperatureRuleService.getRuleForProduct(productType, date);

        if (rule != null) {
            return ResponseEntity.status(200).body(rule);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
