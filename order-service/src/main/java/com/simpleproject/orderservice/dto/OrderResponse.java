package com.simpleproject.orderservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderResponse {
    private String orderNumber;
    private List<OrderItemResponse> items;
}