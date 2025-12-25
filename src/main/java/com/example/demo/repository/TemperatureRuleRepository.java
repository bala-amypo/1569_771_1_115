package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    // REQUIRED by service
    Optional<TemperatureRule>
    findByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
            String productType,
            LocalDate from,
            LocalDate to
    );

    // REQUIRED by service
    java.util.List<TemperatureRule> findByActiveTrue();
}
