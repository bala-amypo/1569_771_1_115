package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    @Autowired
    TemperatureRuleRepository temperaturerulerepository;

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {

        if (rule.getMinTemp() < rule.getMaxTemp()) {
            return temperaturerulerepository.save(rule);
        } else {
            return null;
        }
    }

    @Override
    public TemperatureRule updateRule(long id, TemperatureRule rule) {

        TemperatureRule existingRule =
                temperaturerulerepository.findById(id).orElse(null);

        if (existingRule != null) {
            existingRule.setMinTemp(rule.getMinTemp());
            existingRule.setMaxTemp(rule.getMaxTemp());
            existingRule.setActive(rule.getActive());
            return temperaturerulerepository.save(existingRule);
        } else {
            return null;
        }
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return temperaturerulerepository.findByActiveTrue();
    }

    @Override
    public TemperatureRule getRuleForProduct(String productType, LocalDate date) {
        return temperaturerulerepository
                .findByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
                        productType, date, date);
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return temperaturerulerepository.findAll();
    }
}
