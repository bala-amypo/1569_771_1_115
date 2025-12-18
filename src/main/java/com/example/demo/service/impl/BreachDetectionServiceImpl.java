package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    @Autowired
    BreachRecordRepository breachRecordRepository;

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        breach.setResolved(false);
        return breachRecordRepository.save(breach); 
    }

    @Override
    public BreachRecord resolveBreach(Long id) {
        BreachRecord breach = breachRecordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Breach not found with ID: " + id));
        breach.setResolved(true);
        return breachRecordRepository.save(breach);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        List<BreachRecord> breaches = breachRecordRepository.findByShipmentId(shipmentId);

        if (breaches.isEmpty()) {
            throw new RuntimeException("No breaches found for Shipment ID ");
        }

        return breaches;
    }

    @Override
    public BreachRecord getBreachById(long id) {
        return breachRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Breach not found with ID: " + id));
    }

    @Override
    public List<BreachRecord> getAllBreaches() {
        return breachRecordRepository.findAll();
    }
}
