package com.sm.RedisCache.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.RedisCache.entity.User;
import com.sm.RedisCache.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping()
	public ResponseEntity<List<User>> getAllUser(){
		List<User> list=  userService.getAllUser();
		return list != null ? ResponseEntity.ok(list) : ResponseEntity.notFound().build();
	}


	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userService.getUserById(id);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	// Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Validated User user) {
        Optional<User> existingUser = Optional.of(userService.getUserById(id));
        if (existingUser.isPresent()) {
            user.setId(id);  // Set the ID of the user to ensure it updates the correct one.
            User updatedUser = userService.saveUser(user);
          //  logger.info("User with ID: {} updated successfully.", id);
            return ResponseEntity.ok(updatedUser);
        }
    //    logger.warn("User with ID: {} not found for update.", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
