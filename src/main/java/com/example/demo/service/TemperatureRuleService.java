package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;

import java.util.List;

public interface TemperatureRuleService {

    List<TemperatureRule> getActiveRules();

    TemperatureRule getApplicableRule(String productType);
}
