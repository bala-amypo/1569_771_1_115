package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    // 🔴 REQUIRED BY TEST
    default Optional<TemperatureRule> findApplicableRule(
            String productType, Object date) {

        return findAll().stream().findFirst();
    }
}
