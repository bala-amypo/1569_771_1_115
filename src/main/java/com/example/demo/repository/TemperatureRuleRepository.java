package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    // REQUIRED by test
    default Optional<TemperatureRule> findApplicableRule(
            String productType, LocalDate date) {

        return findAll().stream()
                .filter(r -> r.getProductType().equals(productType))
                .filter(r -> !date.isBefore(r.getEffectiveFrom())
                        && !date.isAfter(r.getEffectiveTo()))
                .findFirst();
    }
}
