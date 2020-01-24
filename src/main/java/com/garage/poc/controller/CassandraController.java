package com.garage.poc.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.garage.poc.cassandra.config.CassandraConfig;
import com.garage.poc.cassandra.domain.CassandraCustomer;
import com.garage.poc.cassandra.domain.CassandraCustomerKey;
import com.garage.poc.cassandra.repository.CustomerCassandraRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CassandraController {
    
	private final CustomerCassandraRepository cassandraRepository;
    
    @GetMapping("/cassandra/save")
    public String save(@RequestParam String eventId,
    		
    		@RequestParam String phoneNo,
    		@RequestParam String name) {
    	
    	//public CassandraCustomer save(@RequestParam String eventId,   	
    	//CassandraConfig configs = new CassandraConfig();
    	
    	//log.info(">>>>>>> [save] Config = " + configs.getInfo());
    	
        // Input Check Routine
    	
    	log.info(">>>>>>> [save] Customer{" + phoneNo + " eventId=" + eventId + " name=" + name + '}');
    	
        final CassandraCustomerKey key = new CassandraCustomerKey(phoneNo, eventId);
        
        log.info(">>>>>>> [save] key=" + key);
        final CassandraCustomer cust = new CassandraCustomer(key, name, LocalDateTime.now());
        log.info(">>>>>>> [save] cust=" + cust);
        CassandraCustomer c = cassandraRepository.save(cust);
 	
        log.info(">>>>>>> [save] cust={}", cust);
        log.info(">>>>>>> [save] cust={}", c);

        return cust.toString();
        //return cust;
    }

    @GetMapping("/cassandra/get")
    public String get(@RequestParam String phoneNo, @RequestParam String eventId) {
    	
    	//public CassandraCustomer save(@RequestParam String eventId,   	
    	//CassandraConfig configs = new CassandraConfig();
    	
    	//log.info(">>>>>>> [save] Config = " + configs.getInfo());
    	
        // Input Check Routine
    	
    	log.info(">>>>>>> [save] Customer{" + phoneNo + " eventId=" + eventId);
    	
        final CassandraCustomerKey key = new CassandraCustomerKey(phoneNo, eventId);
        
        log.info(">>>>>>> [save] key=" + key);
 
        final CassandraCustomer cust = cassandraRepository.findById(key).get();
 	
        log.info(">>>>>>> [save] cust={}", cust);
 

        return cust.toString();
        //return cust;
    }
    // http://localhost:8080/cassandra/save?eventId=20010900&phoneNo=01012345679&name=ABC
    // http://localhost:8080/cache/get?eventId=20010900&phoneNo=01012345678
    @GetMapping("/cassandra/test")
    public String test(@RequestParam String phoneNo, @RequestParam String eventId) {
    	
    	//public CassandraCustomer save(@RequestParam String eventId,   	
    	//CassandraConfig configs = new CassandraConfig();
    	
    	//log.info(">>>>>>> [save] Config = " + configs.getInfo());
    	
        // Input Check Routine
    	
    	log.info(">>>>>>> [test] Customer{" + phoneNo + " eventId=" + eventId);
    	

        
        String str = "  { \"result_code\": 200, \"result_msg\": \"SUCCESS\", \"data\": { \"event_id\":\n" + 
        		"            	  \"2020011301\", \"phone_num\": \"01012345678\", \"name\": \"홍길동\" } }";
            	
            	
            	 
    	/*
    	 * { "result_code": 200, "result_msg": "SUCCESS", "data": { "event_id":
    	 * "2020011301", "phone_num": "01012345678", "name": "홍길동" } }
    	 */

        return str;
        //return cust;
    }
    // http://localhost:8080/cassandra/save?eventId=20010900&phoneNo=01012345679&name=ABC
    // http://localhost:8080/cache/get?eventId=20010900&phoneNo=01012345678
}

// :set nohints
// config set stop-writes-on-bgsave-error no
