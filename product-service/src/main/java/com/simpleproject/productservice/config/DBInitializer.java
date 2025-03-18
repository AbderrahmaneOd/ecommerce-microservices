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

        productList.add(new Product("1", "Smart Glasses", "Augmented reality smart glasses with voice control and HD display.", 299.99, "SKU20001"));
        productList.add(new Product("2", "Wireless Charging Pad", "Fast wireless charging pad for smartphones and wearables.", 39.99, "SKU20002"));
        productList.add(new Product("3", "AI Personal Assistant", "Voice-activated AI assistant with smart home integration.", 199.99, "SKU20003"));
        productList.add(new Product("4", "Digital Notebook", "Smart digital notebook that syncs handwritten notes to the cloud.", 179.99, "SKU20004"));
        productList.add(new Product("5", "Solar-Powered Phone Case", "Eco-friendly phone case with built-in solar charging capability.", 59.99, "SKU20005"));
        productList.add(new Product("6", "Foldable Keyboard", "Compact Bluetooth foldable keyboard for tablets and smartphones.", 49.99, "SKU20006"));
        productList.add(new Product("7", "VR Gaming Headset", "Virtual reality gaming headset with motion tracking and immersive audio.", 399.99, "SKU20007"));
        productList.add(new Product("8", "Smart Mirror", "Touchscreen mirror with weather updates, fitness tracking, and more.", 249.99, "SKU20008"));
        productList.add(new Product("9", "Robot Vacuum Cleaner", "AI-powered robot vacuum cleaner with smart navigation.", 299.99, "SKU20009"));
        productList.add(new Product("10", "Self-Watering Planter", "Automated self-watering planter for indoor plants.", 79.99, "SKU20010"));
        productList.add(new Product("11", "Smart Pet Feeder", "Wi-Fi-enabled pet feeder with scheduled feeding options.", 129.99, "SKU20011"));
        productList.add(new Product("12", "E-Reader Tablet", "Lightweight e-reader with adjustable warm lighting.", 169.99, "SKU20012"));
        productList.add(new Product("13", "Noise-Isolating Earbuds", "Wireless earbuds with active noise cancellation.", 149.99, "SKU20013"));
        productList.add(new Product("14", "Electric Standing Desk", "Height-adjustable electric standing desk with memory presets.", 499.99, "SKU20014"));
        productList.add(new Product("15", "Smart Coffee Maker", "Wi-Fi-enabled coffee maker with remote brewing control.", 199.99, "SKU20015"));
        productList.add(new Product("16", "Compact Drone", "Mini drone with HD camera and smartphone control.", 179.99, "SKU20016"));
        productList.add(new Product("17", "Wireless Smart Doorbell", "Smart doorbell with live video streaming and two-way audio.", 149.99, "SKU20017"));
        productList.add(new Product("18", "Ergonomic Office Chair", "Adjustable ergonomic office chair with lumbar support.", 249.99, "SKU20018"));
        productList.add(new Product("19", "Smart Light Bulb", "Voice-controlled smart LED light bulb with customizable colors.", 29.99, "SKU20019"));
        productList.add(new Product("20", "Ultra-Thin Power Bank", "Slim 20,000mAh power bank with fast charging support.", 39.99, "SKU20020"));
        productList.add(new Product("21", "Portable Espresso Maker", "Compact espresso maker for coffee lovers on the go.", 99.99, "SKU20021"));
        productList.add(new Product("22", "Smart Bike Lock", "Bluetooth-enabled smart bike lock with theft alerts.", 89.99, "SKU20022"));
        productList.add(new Product("23", "Electric Skateboard", "Battery-powered skateboard with remote control.", 349.99, "SKU20023"));
        productList.add(new Product("24", "Self-Cleaning Water Bottle", "UV-powered self-cleaning water bottle for pure hydration.", 79.99, "SKU20024"));
        productList.add(new Product("25", "Portable Projector", "Mini projector with full HD support and wireless connectivity.", 199.99, "SKU20025"));
        productList.add(new Product("26", "Fitness Smart Scale", "Smart scale with body composition analysis and app syncing.", 59.99, "SKU20026"));
        productList.add(new Product("27", "Smart Sleep Mask", "AI-powered sleep mask with soothing light and sound therapy.", 149.99, "SKU20027"));
        productList.add(new Product("28", "Wearable Air Purifier", "Personal air purifier worn around the neck for clean air anywhere.", 129.99, "SKU20028"));
        productList.add(new Product("29", "Virtual Keyboard", "Laser-projected virtual keyboard for typing on any surface.", 119.99, "SKU20029"));
        productList.add(new Product("30", "Smart Refrigerator Camera", "Wi-Fi camera for inside your fridge, view contents remotely.", 99.99, "SKU20030"));

        productRepository.saveAll(productList);

        System.out.println("Product database has been initialized with 30 sample products.");
    }
}

