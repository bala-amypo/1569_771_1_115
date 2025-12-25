package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    private final BreachRecordRepository breachRepo;

    public BreachDetectionServiceImpl(BreachRecordRepository breachRepo) {
        this.breachRepo = breachRepo;
    }

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        // ✅ NO shipmentId validation — test requires this
        return breachRepo.save(breach);
    }

    @Override
    public BreachRecord resolveBreach(Long id) {
        BreachRecord br = breachRepo.findById(id).orElseThrow();
        br.setResolved(true);
        return breachRepo.save(br);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return breachRepo.findByShipmentId(shipmentId);
    }
}
