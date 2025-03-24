package com.sm.RedisCache.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sm.RedisCache.entity.User;
import com.sm.RedisCache.repository.UserRepository;

@Service
public class UserService {
	
	
	
	  @Autowired
	    private UserRepository userRepository;

	  private Logger log = LoggerFactory.getLogger(UserService.class);
	  
	  
	    public User saveUser(User user) {
	    	System.out.println("DB save method is Getting called");
	        return userRepository.save(user);
	    }
	  
	    @Cacheable(value = "users", key = "#id")
	    public User getUserById(Long id) {
	    	System.out.println("DB is Getting called id="+id);
	        return userRepository.findById(id).orElse(null);
	    }

	    @CacheEvict(value = "users", key = "#id")
	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }
	    
	    @Cacheable(value = "users")
	    public List<User> getAllUser(){
	    	return userRepository.findAll();
	    }

	    
	    @CachePut(value = "users", key = "#user.id")
	    public User updateUser(Long id, User user) {
	        System.out.println("DB update method is Getting called");

	        // Check if the user exists in the database
	        User existingUser = userRepository.findById(id).orElse(null);

	        if (existingUser != null) {
	            // Update fields of the existing user with the new user data
	            existingUser.setName(user.getName());
	            existingUser.setEmail(user.getEmail());
	            // Update other fields as necessary

	            // Save the updated user back to the database
	            return userRepository.save(existingUser);
	        } else {
	            // If the user doesn't exist, you can either throw an exception or return null
	            return null;
	        }
	    }
}
