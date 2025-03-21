package com.simpleproject.orderservice.service;

import com.simpleproject.orderservice.config.KafkaOrderProducer;
import com.simpleproject.orderservice.dto.CreateOrderRequest;
import com.simpleproject.orderservice.dto.OrderItemDto;
import com.simpleproject.orderservice.dto.OrderItemResponse;
import com.simpleproject.orderservice.dto.OrderResponse;
import com.simpleproject.orderservice.exception.OrderNotFoundException;
import com.simpleproject.orderservice.model.Order;
import com.simpleproject.orderservice.model.OrderItem;
import com.simpleproject.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final InventoryServiceClient inventoryService;

    private final UserServiceClient userService;

    private final KafkaOrderProducer kafkaOrderProducer;

    // Create a new order
    public void placeOrder(CreateOrderRequest orderRequest) {

        // Check user
        String email = userService.getUserEmailById(orderRequest.getUserId());
        if (email == null || email.isEmpty()){
            throw new IllegalStateException("User " + orderRequest.getUserId() + " is not found");
        }

        // Check inventory
        for (OrderItemDto orderItem : orderRequest.getOrderItems()) {
            boolean inStock = inventoryService.checkInventory(orderItem.getSkuCode(), orderItem.getQuantity());
            if (!inStock) {
                throw new IllegalStateException("Product " + orderItem.getSkuCode() + " is not in stock");
            }
        }

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        // Map OrderItemDto to OrderItem and set it to the Order
        List<OrderItem> orderItems = orderRequest.getOrderItems()
                .stream()
                .map(this::mapToOrderItem) // Convert DTOs to entities
                .toList();

        order.setItems(orderItems);

        // Save the Order
        orderRepository.save(order);
        log.info("Order {} is saved successfully", order.getId());

        // Prepare OrderResponse
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderNumber(order.getOrderNumber());
        orderResponse.setUserEmail(email);
        orderResponse.setItems(orderRequest.getOrderItems());

        // Send notification to Kafka
        kafkaOrderProducer.sendOrder(orderResponse);
    }

    // Get all orders
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToOrderResponse)
                .toList();
    }

    // Get an order by ID
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + id));
        return mapToOrderResponse(order);
    }

    // Update an order
    public void updateOrder(Long id, CreateOrderRequest orderRequest) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + id));

        List<OrderItem> updatedItems = orderRequest.getOrderItems()
                .stream()
                .map(this::mapToOrderItem)
                .toList();

        order.setItems(updatedItems);
        orderRepository.save(order);

        log.info("Order {} updated successfully", id);
    }

    // Delete an order
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException("Order not found with ID: " + id);
        }
        orderRepository.deleteById(id);
        log.info("Order with ID {} deleted successfully", id);
    }


    // This method converts an OrderItemDto to an OrderItem
    private OrderItem mapToOrderItem(OrderItemDto orderItemDto) {
        return OrderItem.builder()
                .skuCode(orderItemDto.getSkuCode())
                .unitPrice(orderItemDto.getUnitPrice())
                .quantity(orderItemDto.getQuantity())
                .build();
    }

    // Map Order entity to Response DTO
    private OrderResponse mapToOrderResponse(Order order) {
        return OrderResponse.builder()
                .orderNumber(order.getOrderNumber())
                .items(order.getItems()
                        .stream()
                        .map(item -> OrderItemDto.builder()
                                .skuCode(item.getSkuCode())
                                .unitPrice(item.getUnitPrice())
                                .quantity(item.getQuantity())
                                .build())
                        .toList())
                .build();
    }

}
