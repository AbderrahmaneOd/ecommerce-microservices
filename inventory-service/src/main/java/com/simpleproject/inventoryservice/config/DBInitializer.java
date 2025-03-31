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

        inventoryList.add(new Inventory(null, "SKU20001", 250));
        inventoryList.add(new Inventory(null, "SKU20002", 120));
        inventoryList.add(new Inventory(null, "SKU20003", 0));
        inventoryList.add(new Inventory(null, "SKU20004", 12));
        inventoryList.add(new Inventory(null, "SKU20005", 0));
        inventoryList.add(new Inventory(null, "SKU20006", 75));
        inventoryList.add(new Inventory(null, "SKU20007", 0));
        inventoryList.add(new Inventory(null, "SKU20008", 80));
        inventoryList.add(new Inventory(null, "SKU20009", 7));
        inventoryList.add(new Inventory(null, "SKU20010", 48));
        inventoryList.add(new Inventory(null, "SKU20011", 90));
        inventoryList.add(new Inventory(null, "SKU20012", 30));
        inventoryList.add(new Inventory(null, "SKU20013", 20));
        inventoryList.add(new Inventory(null, "SKU20014", 4));
        inventoryList.add(new Inventory(null, "SKU20015", 10));
        inventoryList.add(new Inventory(null, "SKU20016", 6));
        inventoryList.add(new Inventory(null, "SKU20017", 88));
        inventoryList.add(new Inventory(null, "SKU20018", 0));
        inventoryList.add(new Inventory(null, "SKU20019", 30));
        inventoryList.add(new Inventory(null, "SKU20020", 20));
        inventoryList.add(new Inventory(null, "SKU20021", 0));
        inventoryList.add(new Inventory(null, "SKU20022", 10));
        inventoryList.add(new Inventory(null, "SKU20023", 20));
        inventoryList.add(new Inventory(null, "SKU20024", 3));
        inventoryList.add(new Inventory(null, "SKU20025", 1));
        inventoryList.add(new Inventory(null, "SKU20026", 20));
        inventoryList.add(new Inventory(null, "SKU20027", 7));
        inventoryList.add(new Inventory(null, "SKU20028", 10));
        inventoryList.add(new Inventory(null, "SKU20029", 0));
        inventoryList.add(new Inventory(null, "SKU20030", 2));

        inventoryRepository.saveAll(inventoryList);

        System.out.println("Inventory database has been initialized with sample data.");
    }
}

