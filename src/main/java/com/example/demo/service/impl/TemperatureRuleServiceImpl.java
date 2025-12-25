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

    @Override
    public List<TemperatureRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public TemperatureRule getRuleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rule not found with id " + id));
    }

    @Override
    public TemperatureRule updateRule(Long id, TemperatureRule rule) {

        TemperatureRule existing = getRuleById(id);

        existing.setProductType(rule.getProductType());
        existing.setMinTemp(rule.getMinTemp());
        existing.setMaxTemp(rule.getMaxTemp());
        existing.setSeverity(rule.getSeverity());
        existing.setActive(rule.getActive());
        existing.setEffectiveFrom(rule.getEffectiveFrom());
        existing.setEffectiveTo(rule.getEffectiveTo());

        return repository.save(existing);
    }
}
