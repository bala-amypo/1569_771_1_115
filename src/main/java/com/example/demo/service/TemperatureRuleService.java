package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;

import java.time.LocalDate;
import java.util.List;

public interface TemperatureRuleService {

    TemperatureRule createRule(TemperatureRule rule);

    List<TemperatureRule> getActiveRules();

    TemperatureRule getRuleForProduct(String productType, LocalDate date);

    List<TemperatureRule> getAllRules();

    // 🔴 ADD THESE (Controller requires them)
    TemperatureRule getRuleById(Long id);

    TemperatureRule updateRule(Long id, TemperatureRule rule);
}
