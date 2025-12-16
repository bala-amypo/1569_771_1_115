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
        tr.setMaxTemp(rule.getMaxTemp());
        tr.setActive(rule.isActive());
        return temperaturerulerepository.save(tr);
    }

    @Override
    public List<TemperatureRule> getActiveRules(){
        return temperaturerulerepository;//doubtuh
    }

    @Override
    public TemperatureRule getRuleForProduct(String productType,LocalDate date){
           
    }
}
 
 
 
 
    
    
    
    List<TemperatureRule> getAllRules();