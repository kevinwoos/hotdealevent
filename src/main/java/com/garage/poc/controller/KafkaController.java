package com.garage.poc.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garage.poc.kafka.domain.KafkaCustomer;
import com.garage.poc.service.CustomerProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class KafkaController {

	@Autowired
	private CustomerProvider customerProvider;
	
	@RequestMapping("/provider")
	public String provider(@RequestParam String eventId,
    		@RequestParam String phoneNo,
    		@RequestParam String name) {
		
		KafkaCustomer cust = new KafkaCustomer(eventId, phoneNo, name, LocalDateTime.now());
		customerProvider.sendMessage(cust);
		
		// http://localhost:8080/provider?eventId=20010900&phoneNo=01012345679&name=ABC
			
		return cust.toString();
	}
	
}
