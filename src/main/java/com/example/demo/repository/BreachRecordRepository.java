package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BreachRecord;

public interface BreachRecordRepository extends JpaRepository<BreachRecord, Long> {

    List<BreachRecord> findByShipmentId(Long shipmentId);
}
