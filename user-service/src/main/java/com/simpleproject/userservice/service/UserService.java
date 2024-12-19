package com.simpleproject.userservice.service;

import com.simpleproject.userservice.dto.UserDTO;
import com.simpleproject.userservice.model.User;
import com.simpleproject.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get user by ID and return a UserDTO
    public UserDTO getUserById(String id) {
        return userRepository.findById(id)
                .map(user -> new UserDTO(user.getId(), user.getEmail(), user.getUsername()))
                .orElse(null);
    }

    // Get all users and return as a list of UserDTOs
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(user.getId(), user.getEmail(), user.getUsername()))
                .collect(Collectors.toList());
    }

    // Get user email by ID (for checking if the user exists)
    public String getUserEmailById(String id) {
        return userRepository.findById(id)
                .map(User::getEmail)
                .orElse(null);
    }

    // Update user information
    public User updateUser(String id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);  // Make sure the ID is preserved
            return userRepository.save(user);
        }
        return null;
    }

    // Delete a user
    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}