package com.garage.poc.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.garage.poc.redis.domain.Customer;
import com.garage.poc.redis.repository.CustomerRedisRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HotdealEventServiceImpl implements HotdealEventService {

	@Override
	public boolean existCustomer(CustomerRedisRepository redis, String key) {
	  	//String key = eventId + ":" + phoneNo;

    	boolean exist = redis.existsById(key);
    	
    	log.info(">>>>>>> [exist] boolean={}", exist);
    	return exist;
	}

	@Override
	public Customer getCustomer(CustomerRedisRepository redis, String key) {
    	//String key = eventId + ":" + phoneNo;

    	Customer cust = redis.findById(key).get();
    	return cust;
	}

	@Override
	public Customer upsertCustomer(CustomerRedisRepository redis, String key, String value) {
    	//String key   = eventId + ":" + phoneNo;
    	//String value = name;
    	LocalDateTime now = LocalDateTime.now();
  
    	// http://localhost:8080/cache/save?eventId=20010900&phoneNo=01012345678&name=wonwoo
    	// http://localhost:8080/cache/save?eventId=20010900&phoneNo=01012345679&name=wonwoo
    	
    	Customer cust = Customer.builder()
    			.id(key)
    			.name(value)
    			.refreshTime(now)
    			.build();
    	

        log.info(">>>>>>> [save] cust={}", cust);

        log.info(">>>>>>>>>>>>>> {}", redis.save(cust));

        return cust;
	}

	@Override
	public boolean insertCustomer(CustomerRedisRepository redis, String key, String value) {
    	//String key = eventId + ":" + phoneNo;

    	boolean exist = redis.existsById(key);
    	
    	log.info(">>>>>>> [dup] key={} : {}", key, exist);
    	
    	if (exist) {
    		return exist;
    	}
    	
    	//String value = name;
    	LocalDateTime now = LocalDateTime.now();
  
    	// http://localhost:8080/cache/save?eventId=20010900&phoneNo=01012345678&name=wonwoo
    	// http://localhost:8080/cache/save?eventId=20010900&phoneNo=01012345679&name=wonwoo
    	
    	Customer cust = Customer.builder()
    			.id(key)
    			.name(value)
    			.refreshTime(now)
    			.build();
    	
    	log.info(">>>>>>> [dup] cust={}", redis.save(cust));
    	
    	return exist;
	}

}
