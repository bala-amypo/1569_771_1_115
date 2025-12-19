package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    List<TemperatureRule> findByActiveTrue();
    Optional<TemperatureRule> findApplicableRule(String productType, Object value);

    // Logic: productType matches AND effectiveFrom <= date AND effectiveTo >= date
    Optional<TemperatureRule> findByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
            String productType, LocalDate date1, LocalDate date2);
}

