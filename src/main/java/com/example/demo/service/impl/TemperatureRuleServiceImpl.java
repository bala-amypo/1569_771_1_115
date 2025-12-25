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
    public List<TemperatureRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public TemperatureRule getApplicableRule(String productType) {
        return repository
                .findFirstByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
                        productType,
                        LocalDate.now(),
                        LocalDate.now()
                )
                .orElse(null);
    }
}
