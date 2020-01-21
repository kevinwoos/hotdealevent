package com.garage.poc.redis.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@ToString
@Getter
@RedisHash("customer")
public class Customer implements Serializable {

    @Id
    private String id; // YYMMDD[00]:PhoneNo
    
    private String name;
    private LocalDateTime refreshTime;

    @Builder
    public Customer(String id, String name, LocalDateTime refreshTime) {
        this.id = id;
        this.name = name;
        this.refreshTime = refreshTime;
    }
}