package com.simpleproject.notificationservice.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(
            topics = "just-for-testing",
            groupId = "testingId",
            properties = "value.deserializer:org.apache.kafka.common.serialization.StringSerializer")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
