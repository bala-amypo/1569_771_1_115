package com.example.demo.service.impl;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;
import com.example.demo.repository.AlertRecordRepository;

@Service
public AlertServiceImpl implements AlertService{

    @Autowired
    private AlertRecordRepository alertrecordrepository;

    @Override
    public AlertRecord triggerAlert(AlertRecord alert){
        alert.setAcknowledged(false);
        
    }
}


    AlertRecord acknowledgeAlert(Long id);
    List<AlertRecord> getAlertsByShipment(Long shipmentId);
    List<AlertRecord> getAllAlerts();