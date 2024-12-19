package com.simpleproject.orderservice.config;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


// Just for testing Kafka
@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC_NAME_FOR_TESTING= "just-for-testing";


    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME_FOR_TESTING, message);
        System.out.println("Message " + message +
                " has been sucessfully sent to the topic: " + TOPIC_NAME_FOR_TESTING);
    }

}
