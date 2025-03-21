package com.simpleproject.userservice.controller;

import com.simpleproject.userservice.dto.UserDTO;
import com.simpleproject.userservice.model.User;
import com.simpleproject.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    private final PagedResourcesAssembler<UserDTO> pagedResourcesAssembler;
    public UserController(UserService userService, PagedResourcesAssembler<UserDTO> pagedResourcesAssembler) {
        this.userService = userService;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        UserDTO userDTO = userService.getUserById(id);
        if (userDTO != null) {
            return ResponseEntity.ok(userDTO);
        }
        return ResponseEntity.notFound().build();
    }

    // Get all users
    //@GetMapping
    //public ResponseEntity<List<UserDTO>> getAllUsers() {
    //    List<UserDTO> users = userService.getAllUsers();
    //    return ResponseEntity.ok(users);
    //}

    // Get paginated users
    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<UserDTO>>> getAllUsers(
            @RequestParam(defaultValue = "") String username,
            @RequestParam(defaultValue = "") String email,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<UserDTO> users = userService.getAllUsers(username, email, pageable);

        // Convert to a stable PagedModel with HATEOAS links
        PagedModel<EntityModel<UserDTO>> userPagedModel = pagedResourcesAssembler.toModel(users);

        return ResponseEntity.ok(userPagedModel);
    }

    /*@GetMapping("/filter")
    public ResponseEntity<List<UserDTO>> getFilteredUser(
            @RequestParam(defaultValue = "") String username,
            @RequestParam(defaultValue = "") String email
    ){
        return ResponseEntity.ok(userService.getFilteredUser(username, email));
    }*/

    // Count user
    @GetMapping("/count")
    public ResponseEntity<Long> getUserCount() {
        try {
            long count = userService.getUserCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Check if user exists by ID and return their email
    @GetMapping("/{id}/email")
    public ResponseEntity<String> getUserEmailById(@PathVariable String id) {
        String email = userService.getUserEmailById(id);
        if (email != null) {
            return ResponseEntity.ok(email);
        }
        return ResponseEntity.notFound().build();
    }

    // Check if user exists by ID and return boolean
    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> doesUserExist(@PathVariable String id) {
        boolean exists = userService.doesUserExist(id);
        if(exists)
            return ResponseEntity.ok(true);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
