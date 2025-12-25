package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.TemperatureRule;
import java.util.List;
import java.util.Optional;

public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    Optional<TemperatureRule> findByProductTypeAndActiveTrue(String productType);

    List<TemperatureRule> findByActiveTrue();
}
