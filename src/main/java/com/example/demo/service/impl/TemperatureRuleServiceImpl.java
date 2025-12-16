package com.example.demo.service.impl;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import com.example.demo.repository.TemperatureRuleRepository;

@Service
public TemperatureRuleServiceImpl implements TemperatureRuleService{
    @Autowired
    TemperatureRuleRepository temperaturerulerepository

    @Override
    public TemperatureRule createRule(TemperatureRule rule){
        return temperaturerulerepository.save(rule);
    }

    @Override
    public TemperatureRule updateRule(long id,TemperatureRule rule){
        TemperatureRule tr= temperaturerulerepository.findById(id);
        tr.setMinTemp(rule.getMinTemp());
        tr.setMax
        return temperaturerulerepository.save(rule);
    }

    @Override
    public List<TemperatureRule> getActiveRules(){
        return temperaturerulerepository.findAll();
    }

    @Override
    public TemperatureRule getRuleForProduct(String productType,LocalDate date){

    }
}
 
 
 
 
    
    
    
    List<TemperatureRule> getAllRules();