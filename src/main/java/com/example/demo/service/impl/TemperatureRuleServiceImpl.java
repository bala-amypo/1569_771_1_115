package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import com.example.demo.repository.TemperatureRuleRepository;

@Service
public TemperatureRuleServiceImpl implements TemperatureRuleService{
    @Autowired
    TemperatureRuleRepository temperaturerulerepository

    @Override
    TemperatureRule createRule(TemperatureRule rule){
        return temperaturerulerepository.save(rule);
    }

    @Override
    TemperatureRule updateRule(long id,TemperatureRule rule){
        TemperatureRule tr= temperaturerulerepository.findById(id);
        tr.setRule(rule);
        return temperaturerulerepository.save()
    }
}
 
 
 
 
    
    List<TemperatureRule> getActiveRules();
    TemperatureRule getRuleForProduct(String productType,LocalDate date);
    List<TemperatureRule> getAllRules();