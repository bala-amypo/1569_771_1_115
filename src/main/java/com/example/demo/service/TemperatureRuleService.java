package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;

import java.time.LocalDate;
import java.util.List;

public interface TemperatureRuleService {

    TemperatureRule createRule(TemperatureRule rule);

    List<TemperatureRule> getActiveRules();

    TemperatureRule getRuleForProduct(String productType, LocalDate date);

    // 🔴 THIS METHOD MUST EXIST (tests expect it)
    List<TemperatureRule> getAllRules();
}
