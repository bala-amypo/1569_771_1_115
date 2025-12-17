package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.ShipmentRecord;

@Repository
public interface ShipmentRecordRepository extends JpaRepository<ShipmentRecord, Long> {
    ShipmentRecord findByShipmentCode(String shipmentCode);
}