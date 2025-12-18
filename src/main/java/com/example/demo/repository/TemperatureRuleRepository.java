package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TemperatureRule;

@Repository
public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    
    List<TemperatureRule> findByActiveTrue();

    
    TemperatureRule findByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
            String productType,
            LocalDate date1,
            LocalDate date2
    );
}
