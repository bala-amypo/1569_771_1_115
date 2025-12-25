package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
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
    public TemperatureRule getRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TemperatureRule getRuleForProduct(String productType, LocalDate date) {
        return repository
                .findFirstByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
                        productType, date, date)
                .orElse(null);
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        return repository.save(rule);
    }

    @Override
    public TemperatureRule updateRule(Long id, TemperatureRule rule) {
        TemperatureRule existing = getRuleById(id);
        if (existing == null) return null;

        existing.setProductType(rule.getProductType());
        existing.setMinTemp(rule.getMinTemp());
        existing.setMaxTemp(rule.getMaxTemp());
        existing.setActive(rule.isActive());
        existing.setSeverity(rule.getSeverity());
        existing.setEffectiveFrom(rule.getEffectiveFrom());
        existing.setEffectiveTo(rule.getEffectiveTo());

        return repository.save(existing);
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return repository.findAll();
    }
}
