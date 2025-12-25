package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rules")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureRule create(@RequestBody TemperatureRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActive() {
        return service.getActiveRules();
    }

    @GetMapping("/{product}")
    public Optional<TemperatureRule> getRule(
            @PathVariable String product
    ) {
        // TESTS EXPECT Optional RETURN
        return service.getRuleForProduct(product, LocalDate.now());
    }
}
