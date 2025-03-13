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
	  
	 
	  
	    @Cacheable(value = "users", key = "#id")
	    public User getUserById(Long id) {
	    	System.out.println("DB is Getting called id="+id);
	        return userRepository.findById(id).orElse(null);
	    }

	    @CachePut(value = "users", key = "#user.id")
	    public User saveUser(User user) {
	    	System.out.println("DB save method is Getting called");
	        return userRepository.save(user);
	    }

	    @CacheEvict(value = "users", key = "#id")
	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }
	    
	    @Cacheable(value = "users")
	    public List<User> getAllUser(){
	    	return userRepository.findAll();
	    }

}
