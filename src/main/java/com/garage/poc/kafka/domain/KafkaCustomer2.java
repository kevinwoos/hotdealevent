package com.garage.poc.kafka.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class KafkaCustomer2 {

    private String eventId; // YYMMDD[00]
    private String phoneNo;    
    private String name;
    private LocalDateTime refreshTime;

    public KafkaCustomer2(String eventId, String phoneNo, String name, LocalDateTime refreshTime) {
        this.eventId = eventId;
        this.phoneNo = phoneNo;
        this.name = name;
        this.refreshTime = refreshTime;
    }
}
