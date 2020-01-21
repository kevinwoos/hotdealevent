package com.garage.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garage.poc.redis.domain.Customer;
import com.garage.poc.redis.repository.CustomerRedisRepository;
import com.garage.poc.service.HotdealEventService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RedisCacheController {
    private final CustomerRedisRepository customerRedisRepository;
    private final RedisTemplate redisTemplate;
    
    @Autowired
	private HotdealEventService eventService;
    
    @GetMapping("/cache/save")
    public Customer save(@RequestParam String eventId,
    		@RequestParam String phoneNo,
    		@RequestParam String name) {
    	
        // Input Check Routine
    	
    	// 
    	String key   = makeKey(eventId, phoneNo);
    	String value = makeValue(name);
    	
    	return eventService.upsertCustomer(customerRedisRepository, key, value);
    }

    // http://localhost:8080/cache/get?eventId=20010900&phoneNo=01012345679
    // http://localhost:8080/cache/get?eventId=20010900&phoneNo=01012345678
    
    
    @GetMapping("/cache/get")
    public Customer get (@RequestParam String eventId,
    		@RequestParam String phoneNo) {
  
    	String key = makeKey(eventId, phoneNo);

    	return eventService.getCustomer(customerRedisRepository, key);
    }
    
    @GetMapping("/cache/exist")
    public boolean exist (@RequestParam String eventId,
    		@RequestParam String phoneNo) {
  
    	String key   = makeKey(eventId, phoneNo);

    	return eventService.existCustomer(customerRedisRepository, key);
    }
    
    @GetMapping("/cache/dup")
    public boolean dup (@RequestParam String eventId,
    		@RequestParam String phoneNo,
    		@RequestParam String name) {
  
    	String key   = makeKey(eventId, phoneNo);
    	String value = makeValue(name);
    	
    	return eventService.insertCustomer(customerRedisRepository, key, value);
    }
    
    @PostMapping("/cache/dup")
    public boolean dup2 (@RequestParam String eventId,
    		@RequestParam String phoneNo,
    		@RequestParam String name) {
  
    	String key   = makeKey(eventId, phoneNo);
    	String value = makeValue(name);
    	
    	return eventService.insertCustomer(customerRedisRepository, key, value);
    }

    private String makeKey(String eventId, String phoneNo) {
    	return eventId + ":" + phoneNo;
    }
    private String makeValue(String name) {
    	return name;
    }
}

// :set nohints
// config set stop-writes-on-bgsave-error no
