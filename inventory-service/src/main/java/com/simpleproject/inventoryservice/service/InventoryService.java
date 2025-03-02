package com.simpleproject.inventoryservice.service;


import com.simpleproject.inventoryservice.dto.InventoryResponse;
import com.simpleproject.inventoryservice.model.Inventory;
import com.simpleproject.inventoryservice.repository.InventoryRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public Boolean isInStock(String skuCode, int quantity) {
        // Fetch the inventory by SKU code
        Optional<Inventory> inventoryOptional = inventoryRepository.findBySkuCode(skuCode);

        if (inventoryOptional.isEmpty()) {
//            return InventoryResponse.builder()
//                    .skuCode(skuCode)
//                    .isInStock(false)
//                    .build();
            return false;
        }

        Inventory inventory = inventoryOptional.get();

        // Check if the quantity is sufficient
        boolean inStock = inventory.getQuantity() >= quantity;

        return  inStock;

//        return InventoryResponse.builder()
//                .skuCode(skuCode)
//                .isInStock(inStock)
//                .build();
    }


    public Inventory getInventoryDetails(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode)
                .orElseThrow(() -> new RuntimeException("Inventory not found for SKU code: " + skuCode));
    }

    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory updateStockQuantity(String skuCode, int quantity) {
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode)
                .orElseThrow(() -> new RuntimeException("Inventory not found for SKU code: " + skuCode));
        inventory.setQuantity(quantity);
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }
}
