package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    // ✅ REQUIRED BY SERVICE
    Optional<TemperatureRule> findByProductTypeAndActiveTrue(String productType);

    // ✅ REQUIRED BY SERVICE
    List<TemperatureRule> findByActiveTrue();
}
