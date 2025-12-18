package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TemperatureRule;

@Repository
public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    List<TemperatureRule> findByActiveTrue();
    Optional<TemperatureRule> findApplicableRule(String productType, LocalDate date);
}
