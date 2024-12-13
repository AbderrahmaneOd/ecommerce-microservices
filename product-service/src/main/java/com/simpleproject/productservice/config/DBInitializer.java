package com.simpleproject.productservice.config;

import com.simpleproject.productservice.model.Product;
import com.simpleproject.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DBInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DBInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product("1", "Ultra HD TV 55\"", "55-inch 4K Ultra HD smart TV with HDR and Wi-Fi.", 799.99, "SKU12345"));
        productList.add(new Product("2", "Wireless Headphones", "Noise-cancelling over-ear wireless headphones with Bluetooth connectivity.", 129.99, "SKU12346"));
        productList.add(new Product("3", "Laptop Backpack", "Water-resistant backpack for laptops up to 15 inches, with multiple compartments.", 49.99, "SKU12347"));
        productList.add(new Product("4", "Bluetooth Speaker", "Portable Bluetooth speaker with 360° sound and 12-hour battery life.", 69.99, "SKU12348"));
        productList.add(new Product("5", "Smartphone - 128GB", "Latest model smartphone with a 128GB storage, 6.5-inch display, and powerful camera.", 699.99, "SKU12349"));
        productList.add(new Product("6", "Electric Kettle", "1.7L electric kettle with rapid boiling and automatic shut-off.", 29.99, "SKU12350"));
        productList.add(new Product("7", "Fitness Tracker", "Water-resistant fitness tracker with heart rate monitoring and sleep tracking.", 79.99, "SKU12351"));
        productList.add(new Product("8", "Portable Power Bank", "10,000mAh portable power bank with dual USB output for charging devices.", 29.99, "SKU12352"));
        productList.add(new Product("9", "Instant Pot Pressure Cooker", "Electric pressure cooker with multiple functions, including slow cooking and sautéing.", 99.99, "SKU12353"));
        productList.add(new Product("10", "Electric Toothbrush", "Rechargeable electric toothbrush with 3 brushing modes and timer function.", 59.99, "SKU12354"));
        productList.add(new Product("11", "Home Security Camera", "Wireless home security camera with HD resolution and night vision.", 119.99, "SKU12355"));
        productList.add(new Product("12", "Kitchen Blender", "High-power blender for smoothies, soups, and sauces, with multiple speed settings.", 89.99, "SKU12356"));
        productList.add(new Product("13", "Cordless Vacuum Cleaner", "Lightweight cordless vacuum cleaner with long battery life and easy-to-clean filter.", 149.99, "SKU12357"));
        productList.add(new Product("14", "Smart Thermostat", "Wi-Fi-enabled smart thermostat for energy-efficient temperature control.", 129.99, "SKU12358"));
        productList.add(new Product("15", "Gaming Mouse", "Ergonomic gaming mouse with customizable buttons and RGB lighting.", 49.99, "SKU12359"));

        productRepository.saveAll(productList);

        System.out.println("Product database has been initialized with sample data.");
    }
}
