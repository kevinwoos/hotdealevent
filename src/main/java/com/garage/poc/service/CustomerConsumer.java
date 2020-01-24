package com.garage.poc.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

import com.garage.poc.kafka.domain.KafkaCustomer;

@Service
public class CustomerConsumer {
	private final Logger logger = LoggerFactory.getLogger(CustomerConsumer.class);

	@KafkaListener(topics = "hotdeal", groupId = "group_id")

	public void consume(KafkaCustomer kafkaCustomer) throws IOException {
		logger.info(String.format("#### -> Consumed message -> %s", kafkaCustomer.toString()));

	}

	/*
	 * public void consume(String msg) throws IOException {
	 * logger.info(String.format("#### -> Consumed message -> %s", msg));
	 * 
	 * }
	 */
}
