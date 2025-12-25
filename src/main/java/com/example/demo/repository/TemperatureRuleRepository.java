package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    // ✔ Used by service
    List<TemperatureRule> findByActiveTrue();

    Optional<TemperatureRule>
    findFirstByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
            String productType,
            LocalDate from,
            LocalDate to
    );
}
