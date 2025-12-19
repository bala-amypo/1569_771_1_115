package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TemperatureSensorLog;

import java.util.List;

public interface TemperatureSensorLogRepository extends JpaRepository<TemperatureSensorLog, Long> {
    List<TemperatureSensorLog> findByShipment_Id(Long shipmentId);
}