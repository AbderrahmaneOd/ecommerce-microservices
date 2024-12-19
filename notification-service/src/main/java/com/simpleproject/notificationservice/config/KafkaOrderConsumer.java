package com.simpleproject.notificationservice.config;

import com.simpleproject.notificationservice.dto.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaOrderConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderResponse orderResponse) {
        log.info("Order received from Kafka: {}", orderResponse);

        // Process the order notification logic
        sendNotification(orderResponse);
    }

    private void sendNotification(OrderResponse orderResponse) {
        // Notification logic, e.g., send an email or log the order details
        log.info("Sending notification for order with items: {}", orderResponse.getOrderItems());
    }
}