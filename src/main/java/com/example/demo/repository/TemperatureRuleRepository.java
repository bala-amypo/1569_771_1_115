package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TemperatureRule;

public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    Optional<TemperatureRule> findByProductTypeAndActiveTrue(String productType);
}
