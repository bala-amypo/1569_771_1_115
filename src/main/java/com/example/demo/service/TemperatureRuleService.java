package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;
import java.util.List;

public interface TemperatureRuleService {

    TemperatureRule createRule(TemperatureRule rule);

    TemperatureRule getRuleById(Long id);

    TemperatureRule getRuleForProduct(String productType);

    TemperatureRule updateRule(Long id, TemperatureRule rule);

    List<TemperatureRule> getAllRules();

    List<TemperatureRule> getActiveRules();
}
