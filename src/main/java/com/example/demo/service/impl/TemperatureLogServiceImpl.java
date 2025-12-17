package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;
import com.example.demo.repository.TemperatureSensorLogRepository;

@Service
public class TemperatureLogServiceImpl implements TemperatureLogService{
    @Autowired
    TemperatureSensorLogRepository temperaturelogrepository;

    @Override
    public TemperatureSensorLog recordLog(TemperatureSensorLog log){
        return temperaturelogrepository.save(log);
    }

    @Override
    public List<TemperatureSensorLog> getLogsByShipment(long shipmentId){
        return temperaturelogrepository.findByShipmentId(shipmentId);
    }

    @Override
    public TemperatureSensorLog getLogById(long id){
        return temperaturelogrepository.findById(id);
    }

    @Override
    public List<TemperatureSensorLog> getAllLogs(){
        return temperaturelogrepository.findAll();
    }
}