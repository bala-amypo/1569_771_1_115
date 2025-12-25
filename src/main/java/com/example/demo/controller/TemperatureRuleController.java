package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.service.TemperatureRuleService;
import com.example.demo.entity.TemperatureRule;

@RestController
@RequestMapping("/api/rules")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public TemperatureRule getById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    @GetMapping("/product/{type}")
    public TemperatureRule getByProduct(@PathVariable String type) {
        return service.getRuleForProduct(type);
    }

    @PostMapping
    public TemperatureRule create(@RequestBody TemperatureRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TemperatureRule update(@PathVariable Long id, @RequestBody TemperatureRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping
    public List<TemperatureRule> getAll() {
        return service.getAllRules();
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActive() {
        return service.getActiveRules();
    }
}
