package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    private final BreachRecordRepository breachRecordRepository;

    public BreachDetectionServiceImpl(BreachRecordRepository breachRecordRepository) {
        this.breachRecordRepository = breachRecordRepository;
    }

    @Override
public BreachRecord logBreach(BreachRecord breach) {
    // Check if the shipment object exists AND has an ID
    if (breach.getShipment() == null || breach.getShipment().getId() == null) {
        throw new BadRequestException("Shipment ID must be provided");
    }
    
    // Ensure the resolved status is set for new records
    if (breach.getResolved() == null) {
        breach.setResolved(false);
    }
    
    return breachRecordRepository.save(breach); 
}

    @Override
    public List<BreachRecord> getAllBreaches() {
        return breachRecordRepository.findAll();
    }

    @Override
    public BreachRecord getBreachById(long id) {
        return breachRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Breach not found"));
    }
    
    @Override
    public BreachRecord resolveBreach(long id) {
        BreachRecord breach = getBreachById(id);
        breach.setResolved(true);
        return breachRecordRepository.save(breach);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(long shipmentId) {
        return breachRecordRepository.findByShipmentId(shipmentId);
    }
}