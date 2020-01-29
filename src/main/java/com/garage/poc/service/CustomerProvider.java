package com.garage.poc.service;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.garage.poc.common.Constants;
import com.garage.poc.kafka.domain.KafkaCustomer;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerProvider {

	//private static final Logger logger = LoggerFactory.getLogger(CustomerProvider.class);
	//private static final String TOPIC = "hotdeal";

	@Autowired
	// private KafkaTemplate<String, String> kafkaTemplate;
	//private KafkaTemplate<String, KafkaCustomer> kafkaTemplate;
	private KafkaTemplate<Object, Object> kafkaTemplate;

	/*
	 * public void sendMessage(String message) {
	 * logger.info(String.format("#### -> Producing message -> %s", message));
	 * this.kafkaTemplate.send(TOPIC, message); }
	 */

	public void sendMessage(KafkaCustomer kafkaCustomer) {
		log.info(String.format("#### -> Producing message -> %s", kafkaCustomer.toString()));
		this.kafkaTemplate.send(Constants.KAFKA_TOPIC_HOTDEAL_FCFS, kafkaCustomer);
	}

}