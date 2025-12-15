package com.example.demo.entity;

import java.time.LocalDateTime;

public class ShipmentRecord {
       private long id;
       private String shipmentCode;
       private String origin;
       private String destination;
       private String productType;
       private LocalDateTime startDate;
       private LocalDateTime expectedDelivery;
       private String status;
       private LocalDateTime createdAt;

       public class ShipmentRecord(){}
       public class ShipmentRecord(String shipmentCode,String origin,String destination,String productType,)
}
