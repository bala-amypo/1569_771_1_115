package com.example.demo.service.impl;

import java.util.List;

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
        return temperaturelogrepository.findByshipmentId(shipmentId);
    }
    // TemperatureSensorLog getLogById(long id);
    // List<TemperatureSensorLog> getAllLogs();
}