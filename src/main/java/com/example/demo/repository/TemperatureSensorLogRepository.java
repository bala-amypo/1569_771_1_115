package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TemperatureSensorLog;

public interface TemperatureSensorLogRepository extends JpaRepository<TemperatureLog, Long> {

    List<TemperatureSensorLog> findByShipmentIdOrderByRecordedAt(Long shipmentId);
}
