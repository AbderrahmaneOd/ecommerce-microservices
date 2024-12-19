package com.simpleproject.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse implements Serializable {
    private String orderNumber;
    private String userEmail;
    private List<OrderItemResponse> items;
}
