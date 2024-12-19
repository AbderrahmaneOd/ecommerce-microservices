package com.simpleproject.orderservice.controller;


import com.simpleproject.orderservice.config.KafkaOrderProducer;
import com.simpleproject.orderservice.config.KafkaProducer;
import com.simpleproject.orderservice.dto.CreateOrderRequest;
import com.simpleproject.orderservice.dto.OrderResponse;
import com.simpleproject.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/orders")
public class OrderController {

    private final OrderService orderService;
    private final KafkaProducer kafkaProducer; // Just for testing
    private final KafkaOrderProducer kafkaOrderProducer;

    // Create Product
     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public void placeOrder(@RequestBody CreateOrderRequest orderRequest){
        this.orderService.placeOrder(orderRequest);
    }

    // Get all orders
    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Get an order by ID
    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Update an existing order
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@PathVariable Long id, @RequestBody CreateOrderRequest orderRequest) {
        orderService.updateOrder(id, orderRequest);
    }

    // Delete an order
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    // Just for testing Kafka
    @PostMapping("/send")
    public void sendMessageToKafka(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
    }

    @PostMapping("/send-order")
    public ResponseEntity<String> sendOrderToKafka(@RequestBody OrderResponse orderResponse) {
        kafkaOrderProducer.sendOrder(orderResponse);
        return ResponseEntity.ok("Order submitted to Kafka successfully");
    }
}
