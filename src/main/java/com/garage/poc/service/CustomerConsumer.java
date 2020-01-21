package com.garage.poc.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.garage.poc.service.CustomerProvider;

@Service
public class CustomerConsumer {
    private final Logger logger = LoggerFactory.getLogger(CustomerProvider.class);

    @KafkaListener(topics = "hotdeal", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
