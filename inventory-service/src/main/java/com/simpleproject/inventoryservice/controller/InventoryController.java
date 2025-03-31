package com.simpleproject.inventoryservice.controller;

import com.simpleproject.inventoryservice.dto.InventoryResponse;
import com.simpleproject.inventoryservice.model.Inventory;
import com.simpleproject.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventories")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{skuCode}/stock-availability")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isStockAvailable(@PathVariable String skuCode, @RequestParam int quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public Inventory getInventoryDetails(@PathVariable String skuCode) {
        return inventoryService.getInventoryDetails(skuCode);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory addNewInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    @PutMapping("/{skuCode}/quantity")
    @ResponseStatus(HttpStatus.OK)
    public Inventory updateStockQuantity(@PathVariable String skuCode, @RequestParam int quantity) {
        return inventoryService.updateStockQuantity(skuCode, quantity);
    }
}
