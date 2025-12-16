package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import com.example.demo.repository.TemperatureRuleRepository;


 
 
 
 TemperatureRule createRule(TemperatureRule rule);
    TemperatureRule updateRule(long id,TemperatureRule rule);
    List<TemperatureRule> getActiveRules();
    TemperatureRule getRuleForProduct(String productType,LocalDate date);
    List<TemperatureRule> getAllRules();