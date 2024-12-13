package com.simpleproject.inventoryservice.config;

import com.simpleproject.inventoryservice.model.Inventory;
import com.simpleproject.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBInitializer implements CommandLineRunner {

    private final InventoryRepository inventoryRepository;

    public DBInitializer(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Inventory> inventoryList = new ArrayList<>();

        inventoryList.add(new Inventory(null, "SKU12345", 250));
        inventoryList.add(new Inventory(null, "SKU12346", 120));
        inventoryList.add(new Inventory(null, "SKU12347", 50));
        inventoryList.add(new Inventory(null, "SKU12348", 200));
        inventoryList.add(new Inventory(null, "SKU12349", 300));
        inventoryList.add(new Inventory(null, "SKU12350", 75));
        inventoryList.add(new Inventory(null, "SKU12351", 450));
        inventoryList.add(new Inventory(null, "SKU12352", 80));
        inventoryList.add(new Inventory(null, "SKU12353", 600));
        inventoryList.add(new Inventory(null, "SKU12354", 150));
        inventoryList.add(new Inventory(null, "SKU12355", 500));
        inventoryList.add(new Inventory(null, "SKU12356", 30));
        inventoryList.add(new Inventory(null, "SKU12357", 20));
        inventoryList.add(new Inventory(null, "SKU12358", 100));
        inventoryList.add(new Inventory(null, "SKU12359", 10));

        inventoryRepository.saveAll(inventoryList);

        System.out.println("Inventory database has been initialized with sample data.");
    }
}

