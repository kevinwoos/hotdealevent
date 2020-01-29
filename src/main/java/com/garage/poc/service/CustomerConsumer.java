package com.garage.poc.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.garage.poc.common.Constants;
import com.garage.poc.kafka.domain.KafkaCustomer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Service
public class CustomerConsumer {
	//private final Logger logger = LoggerFactory.getLogger(CustomerConsumer.class);

	//@KafkaListener(topics = "hotdeal", groupId = "group_id")

	@KafkaListener(groupId = Constants.KAFKA_TOPIC_HOTDEALS, topicPattern = Constants.KAFKA_TOPIC_HOTDEALS + ".*")
	public void onReceiving(@Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) Long offset,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, KafkaCustomer customer) {
		
		log.info("#### -> Consumed message -> [ {} ] Topic: {}, Partition: {}, Offset: {}, Payload: {}"
				, Constants.KAFKA_TOPIC_HOTDEALS, topic
				, partition, offset, customer.toString());
	}
	
	/*
	 * public void consume(KafkaCustomer kafkaCustomer) throws IOException {
	 * log.info(String.format("#### -> Consumed message -> %s",
	 * kafkaCustomer.toString()));
	 * 
	 * }
	 */
	
	
	/*
	 * public void consume(String msg) throws IOException {
	 * logger.info(String.format("#### -> Consumed message -> %s", msg));
	 * 
	 * }
	 */
}
