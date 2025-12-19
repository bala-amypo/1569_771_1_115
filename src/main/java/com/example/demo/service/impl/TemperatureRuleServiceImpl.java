package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.BadRequestException;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository temperaturerulerepository;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository temperaturerulerepository) {
        this.temperaturerulerepository = temperaturerulerepository;
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        if (rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new BadRequestException("Min temperature must be less than max temperature.");
        }
        if (rule.getEffectiveFrom().isAfter(rule.getEffectiveTo())) {
            throw new BadRequestException("Effective From date must be before Effective To date.");
        }
        return temperaturerulerepository.save(rule);
    }

    @Override
    public TemperatureRule updateRule(long id, TemperatureRule rule) {
        TemperatureRule existingRule = temperaturerulerepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TemperatureRule not found with id: " + id));
        
        existingRule.setMinTemp(rule.getMinTemp());
        existingRule.setMaxTemp(rule.getMaxTemp());
        existingRule.setActive(rule.getActive());
        existingRule.setEffectiveFrom(rule.getEffectiveFrom());
        existingRule.setEffectiveTo(rule.getEffectiveTo());

        return temperaturerulerepository.save(existingRule);
    }

    @Override
    public TemperatureRule getRuleById(Long id) {
        return temperaturerulerepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found with id: " + id));
    }

    @Override
    public TemperatureRule getRuleForProduct(String productType, LocalDate date) {
        return temperaturerulerepository
                .findByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(productType, date, date)
                .orElseThrow(() -> new ResourceNotFoundException("No applicable rule found for product: " + productType));
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return temperaturerulerepository.findByActiveTrue();
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return temperaturerulerepository.findAll();
    }

    // ✅ New method
    @Override
    public Optional<TemperatureRule> findApplicableRule(String productType, LocalDate date) {
        return temperaturerulerepository
                .findByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(productType, date, date);
    }
}
