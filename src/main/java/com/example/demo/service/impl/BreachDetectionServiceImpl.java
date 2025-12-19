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

    private final BreachRecordRepository breachRecordRepository;

    public BreachDetectionServiceImpl(BreachRecordRepository breachRecordRepository) {
        this.breachRecordRepository = breachRecordRepository;
    }

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        // Validation: ensure objects are present before saving
        if (breach.getShipment() == null || breach.getTemperatureLog() == null) {
            throw new BadRequestException("Breach must be linked to a Shipment and a Log record.");
        }
        breach.setResolved(false);
        return breachRecordRepository.save(breach); 
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(long shipmentId) {
        List<BreachRecord> breaches = breachRecordRepository.findByShipmentId(shipmentId);

        if (breaches.isEmpty()) {
            throw new RuntimeException("No breaches found for Shipment ID ");
        }

        return breaches;
    }
    
    @Override
    public BreachRecord resolveBreach(long id) {
        BreachRecord breach = breachRecordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Breach not found with ID: " + id));
        breach.setResolved(true);
        return breachRecordRepository.save(breach);
    }

    @Override
    public BreachRecord getBreachById(long id) {
        return breachRecordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Breach not found with ID: " + id));
    }

    @Override
    public List<BreachRecord> getAllBreaches() {
        return breachRecordRepository.findAll();
    }
}
