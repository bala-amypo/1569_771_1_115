package com.example.demo.service.impl;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;
import com.example.demo.repository.BreachRecordRepository;

@Service
public BreachDetectionServiceImpl implements BreachDetectionService{
       @Autowired
       private BreachRecordRepository breachrecordrepository;

       @Override
       public BreachRecord logBreach(BreachRecord breach){
            breach.setResolved(false);
            return breachrecordrepository.save(breach);
       }

       @Override
       public List<BreachRecord> getBreachesByShipment(long shipmentId){
            return breachrecordrepository.fin
       }
    BreachRecord resolveBreach(long id);
    BreachRecord getBreachById(long id);
    List<BreachRecord> getAllBreaches();
}