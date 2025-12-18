package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AlertRecord;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRecordRepository alertRecordRepository;

    @Override
    public AlertRecord triggerAlert(AlertRecord alert) {
        alert.setAcknowledged(false);
        return alertRecordRepository.save(alert);
    }

    @Override
    public AlertRecord acknowledgeAlert(Long id) {
        AlertRecord alert = alertRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found with ID: " + id));

        alert.setAcknowledged(true);
        return alertRecordRepository.save(alert);
    }

    @Override
    public List<AlertRecord> getAlertsByShipment(Long shipmentId) {
        List<AlertRecord> alerts = alertRecordRepository.findByShipmentId(shipmentId);

        if (alerts.isEmpty()) {
            throw new RuntimeException("No alerts found for Shipment ID: " + shipmentId);
        }

        return alerts;
    }

    @Override
    public List<AlertRecord> getAllAlerts() {
        return alertRecordRepository.findAll();
    }
}
