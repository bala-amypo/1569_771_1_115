// package com.example.demo.service;

// import com.example.demo.entity.TemperatureRule;
// import java.time.LocalDate;
// import java.util.List;

// public interface TemperatureRuleService {

//     TemperatureRule createRule(TemperatureRule rule);

//     TemperatureRule getRuleById(Long id);

//     // ✅ MUST MATCH TEST
//     TemperatureRule getRuleForProduct(String productType, LocalDate date);

//     TemperatureRule updateRule(Long id, TemperatureRule rule);

//     List<TemperatureRule> getAllRules();

//     List<TemperatureRule> getActiveRules();
// }

package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;

import java.time.LocalDate;
import java.util.List;

public interface TemperatureRuleService {

    TemperatureRule createRule(TemperatureRule rule);

    TemperatureRule getRuleForProduct(String productType, LocalDate date);

    List<TemperatureRule> getActiveRules();
}
