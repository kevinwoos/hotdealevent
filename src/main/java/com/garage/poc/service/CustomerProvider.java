package com.garage.poc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.garage.poc.kafka.domain.KafkaCustomer;

@Service
public class CustomerProvider {

    private static final Logger logger = LoggerFactory.getLogger(CustomerProvider.class);
    private static final String TOPIC = "hotdeal";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
    public void sendMessage(KafkaCustomer cust) {
        logger.info(String.format("#### -> Producing message -> %s", cust.toString()));
        this.kafkaTemplate.send(TOPIC, message);
    }
}