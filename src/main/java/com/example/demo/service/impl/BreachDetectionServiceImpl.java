package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    private final BreachRecordRepository breachRepository;

    public BreachDetectionServiceImpl(BreachRecordRepository breachRepository) {
        this.breachRepository = breachRepository;
    }

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        return breachRepository.save(breach);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return breachRepository.findByShipmentId(shipmentId);
    }

    @Override
    public BreachRecord resolveBreach(Long id) {
        BreachRecord breach = breachRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Breach not found"));
        breach.setResolved(true);
        return breachRepository.save(breach);
    }
}
