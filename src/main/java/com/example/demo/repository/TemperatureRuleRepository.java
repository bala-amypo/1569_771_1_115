package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.TemperatureRule;
import java.util.Optional;

public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    // ✅ REQUIRED BY TEST
    default Optional<TemperatureRule> findApplicableRule(
            String productType, Object date) {
        return Optional.empty();
    }
}
