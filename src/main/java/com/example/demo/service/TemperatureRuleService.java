package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;

import java.time.LocalDate;
import java.util.List;

public interface TemperatureRuleService {

    TemperatureRule createRule(TemperatureRule rule);

    TemperatureRule getRuleForProduct(String productType, LocalDate date);

    List<TemperatureRule> getActiveRules();

    List<TemperatureRule> getAllRules();
}
