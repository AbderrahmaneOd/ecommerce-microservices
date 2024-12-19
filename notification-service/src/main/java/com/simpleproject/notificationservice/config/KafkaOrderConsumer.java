package com.simpleproject.notificationservice.config;

import com.simpleproject.notificationservice.dto.OrderResponse;
import com.simpleproject.notificationservice.util.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaOrderConsumer {

    public final EmailService emailService;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderResponse orderResponse) throws MessagingException {
        log.info("Order received from Kafka: {}", orderResponse);

        // Process the order notification logic
        sendNotification(orderResponse);
    }

    private void sendNotification(OrderResponse orderResponse) throws MessagingException {
        // Notification logic, e.g., send an email or log the order details
        log.info("Sending notification for order with items: {}", orderResponse.getItems());
        emailService.sendEmail(orderResponse);
    }
}