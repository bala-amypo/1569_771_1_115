package com.example.demo.service.impl;

import java.time.LocalDateTime; // This was the missing import
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.BadRequestException;

@Service
public class BreachDetection~ServiceImpl implements BreachDetectionService {

    private final BreachRecordRepository breachRecordRepository;

    public BreachDetectionServiceImpl(BreachRecordRepository breachRecordRepository) {
        this.breachRecordRepository = breachRecordRepository;
    }

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        if (breach.getShipment() == null || breach.getShipment().getId() == null) {
            throw new BadRequestException("Shipment ID must be provided");
        }
        
        // Use LocalDateTime safely now that it is imported
        if (breach.getDetectedAt() == null) {
            breach.setDetectedAt(LocalDateTime.now());
        }
        
        if (breach.getResolved() == null) {
            breach.setResolved(false);
        }
        
        return breachRecordRepository.save(breach); 
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(long shipmentId) {
        return breachRecordRepository.findByShipmentId(shipmentId);
    }
    
    @Override
    public BreachRecord resolveBreach(long id) {
        BreachRecord breach = getBreachById(id);
        breach.setResolved(true);
        return breachRecordRepository.save(breach);
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