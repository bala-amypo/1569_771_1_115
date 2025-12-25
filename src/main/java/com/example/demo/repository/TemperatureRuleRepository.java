package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.*;

public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    @Query("""
        SELECT r FROM TemperatureRule r
        WHERE r.productType = :product
        AND r.active = true
        AND :date BETWEEN r.effectiveFrom AND r.effectiveTo
    """)
    Optional<TemperatureRule> findApplicableRule(
            @Param("product") String product,
            @Param("date") LocalDate date
    );

    List<TemperatureRule> findByActiveTrue();
}
