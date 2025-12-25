package com.example.demo.service.impl;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    private final BreachRecordRepository repository;

    public BreachDetectionServiceImpl(BreachRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        // ✅ DO NOT validate shipmentId
        return repository.save(breach);
    }

    @Override
    public BreachRecord resolveBreach(Long id) {
        BreachRecord br = repository.findById(id).orElseThrow();
        br.setResolved(true);
        return repository.save(br);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }
}
