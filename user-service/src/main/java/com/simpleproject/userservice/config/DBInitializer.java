package com.simpleproject.userservice.config;

import com.simpleproject.userservice.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simpleproject.userservice.repository.UserRepository;

@Slf4j
@Configuration
public class DBInitializer {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner initDatabase() {
        return args -> {
            // Array of users to be inserted
            User[] users = {
                    new User(null, "alice@example.com", "alice123", "password123"),
                    new User(null, "bob@example.com", "bob456", "password456"),
                    new User(null, "charlie@example.com", "charlie789", "password789"),
                    new User(null, "david@example.com", "david321", "password321"),
                    new User(null, "eve@example.com", "eve654", "password654"),
                    new User(null, "frank@example.com", "frank987", "password987"),
                    new User(null, "grace@example.com", "grace135", "password135"),
                    new User(null, "hannah@example.com", "hannah246", "password246"),
                    new User(null, "ian@example.com", "ian369", "password369"),
                    new User(null, "jack@example.com", "jack482", "password482"),
                    new User(null, "kelly@example.com", "kelly593", "password593"),
                    new User(null, "leo@example.com", "leo604", "password604"),
                    new User(null, "mia@example.com", "mia715", "password715"),
                    new User(null, "nathan@example.com", "nathan826", "password826"),
                    new User(null, "olivia@example.com", "olivia937", "password937"),
                    new User(null, "paul@example.com", "paul048", "password048"),
                    new User(null, "quincy@example.com", "quincy159", "password159"),
                    new User(null, "rose@example.com", "rose260", "password260"),
                    new User(null, "sam@example.com", "sam371", "password371"),
                    new User(null, "tina@example.com", "tina482", "password482")
            };

            for (User user : users) {
                // Check if the user already exists based on the email
                if (userRepository.findByEmail(user.getEmail()).isEmpty()) {
                    // If the user doesn't exist, save the new user
                    userRepository.save(user);
                }
            }

            log.info("Database has been initialized.");
        };
    }
}

