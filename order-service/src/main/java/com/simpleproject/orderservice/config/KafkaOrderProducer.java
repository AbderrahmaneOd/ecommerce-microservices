package com.simpleproject.orderservice.config;

import com.simpleproject.orderservice.dto.CreateOrderRequest;
import com.simpleproject.orderservice.dto.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaOrderProducer {

    private final KafkaTemplate<String, OrderResponse> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public KafkaOrderProducer(KafkaTemplate<String, OrderResponse> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(OrderResponse orderResponse) {
        kafkaTemplate.send(topicName, orderResponse);
        log.info("Order message sent to Kafka: {}", orderResponse);
    }
}

