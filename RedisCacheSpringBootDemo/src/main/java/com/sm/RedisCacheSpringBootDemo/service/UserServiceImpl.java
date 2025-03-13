package com.sm.RedisCacheSpringBootDemo.service;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.sm.RedisCacheSpringBootDemo.entity.User;

import jakarta.annotation.Resource;

@Repository
public class UserServiceImpl implements UserService {
	
	private final String hashReference= "User";

    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, User> hashOperations;

	@Override
	public void saveUser(User user) {
		 hashOperations.putIfAbsent(hashReference, user.getId(),user);
		
	}

	@Override
	public User getOneUser(Integer id) {
		// TODO Auto-generated method stub
		 return hashOperations.get(hashReference, id);
	}

	@Override
	public void updateUser(User user) {
		 hashOperations.put(hashReference, user.getId(),user);
		
	}

	@Override
	public Map<Integer, User> getAllUser() {
		// TODO Auto-generated method stub
		return hashOperations.entries(hashReference);
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAllEmployees(Map<Integer, User> map) {
		 hashOperations.putAll(hashReference, map);
		
	}

}

