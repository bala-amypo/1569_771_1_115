package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.BadRequestException;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    @Autowired
    private TemperatureRuleRepository temperaturerulerepository;

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        if (rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new BadRequestException("Min temperature must be less than max temperature.");
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

        return temperaturerulerepository.save(existingRule);
    }
    @Override
    public TemperatureRule getRuleForProduct(String productType, LocalDate date) {
        return temperaturerulerepository.findApplicableRule(productType, date).orElse(null); 
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return temperaturerulerepository.findByActiveTrue();
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return temperaturerulerepository.findAll();
    }

    @Override
    public TemperatureRule getRuleById(Long id) {
        return temperaturerulerepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Temperature rule not found with id: " + id));
    }
}
