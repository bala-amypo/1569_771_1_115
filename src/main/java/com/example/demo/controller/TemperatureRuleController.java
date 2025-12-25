package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/rules")
public class TemperatureRuleController {

    private final TemperatureRuleService temperatureRuleService;

    public TemperatureRuleController(TemperatureRuleService temperatureRuleService) {
        this.temperatureRuleService = temperatureRuleService;
    }

    @GetMapping("/product/{type}")
    public TemperatureRule getByProduct(@PathVariable String type) {
        // ✅ PASS CURRENT DATE
        return temperatureRuleService.getRuleForProduct(type, LocalDate.now());
    }
}
