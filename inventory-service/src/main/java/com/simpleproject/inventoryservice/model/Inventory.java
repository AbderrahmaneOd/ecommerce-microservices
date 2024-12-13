package com.simpleproject.inventoryservice.model;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;
}
