package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;

import java.time.LocalDate;
import java.util.List;

public interface TemperatureRuleService {

    TemperatureRule getRuleById(Long id);

    TemperatureRule getRuleForProduct(String productType, LocalDate date);

    TemperatureRule createRule(TemperatureRule rule);

    TemperatureRule updateRule(Long id, TemperatureRule rule);

    List<TemperatureRule> getAllRules();

    // ✅ ADD THIS
    List<TemperatureRule> getActiveRules();
}
