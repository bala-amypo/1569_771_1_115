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

    private final TemperatureRuleRepository repository;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TemperatureRule updateRule(long id, TemperatureRule rule) {
        TemperatureRule existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found with id: " + id));
        
        existing.setProductType(rule.getProductType());
        existing.setMinTemp(rule.getMinTemp());
        existing.setMaxTemp(rule.getMaxTemp());
        existing.setSeverity(rule.getSeverity());
        existing.setActive(rule.getActive());
        existing.setEffectiveFrom(rule.getEffectiveFrom());
        existing.setEffectiveTo(rule.getEffectiveTo());

        return repository.save(existing);
    }
    // ... other methods same as before
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

    // @Override
    // public Optional<TemperatureRule> findApplicableRule(String productType, LocalDate date) {
    //     return temperaturerulerepository
    //             .findByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(productType, date, date);
    // }
}
