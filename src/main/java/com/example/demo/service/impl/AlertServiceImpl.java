package com.example.demo.service.impl;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
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
        return alertrecordrepository.save(alert);
    }

    @Override
    public AlertRecord acknowledgeAlert(Long id){
        AlertRecord alert= alertrecordrepository.findById(id);
        alert.setAcknowledged(true);
        return alertrecordrepository.save(alert);
    }

    @Override
    List<AlertRecord> getAlertsByShipment(Long shipmentId){
        return alertrecordrepository.findByShipmentId(shipmentId);
    }

    @Override
    List<AlertRecord> getAllAlerts(){
        return alertrecordrepository.findAll();
    }
}
