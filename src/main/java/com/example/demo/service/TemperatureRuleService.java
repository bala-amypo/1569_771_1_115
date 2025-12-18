package com.example.demo.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureRule;

@Service
public interface TemperatureRuleService{
    TemperatureRule createRule(TemperatureRule rule);
    TemperatureRule updateRule(long id,TemperatureRule rule);
    TemperatureRule getRuleById(Long id);
    List<TemperatureRule> getActiveRules();
    TemperatureRule getRuleForProduct(String productType,LocalDate date);
    List<TemperatureRule> getAllRules();
}
