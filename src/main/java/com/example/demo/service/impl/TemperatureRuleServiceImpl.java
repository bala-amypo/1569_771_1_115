package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository repository;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public TemperatureRule getRuleForProduct(String productType, LocalDate date) {

        return repository
                .findByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
                        productType, date, date)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Temperature rule not found"));
    }

    // 🔴 THIS METHOD WAS MISSING
    @Override
    public List<TemperatureRule> getAllRules() {
        return repository.findAll();
    }
}
