package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.service.TemperatureRuleService;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.entity.TemperatureRule;

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
    public TemperatureRule getRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TemperatureRule getRuleForProduct(String productType) {
        return repository.findByProductTypeAndActiveTrue(productType).orElse(null);
    }

    @Override
    public TemperatureRule updateRule(Long id, TemperatureRule rule) {
        rule.setId(id);
        return repository.save(rule);
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return repository.findByActiveTrue();
    }
}
