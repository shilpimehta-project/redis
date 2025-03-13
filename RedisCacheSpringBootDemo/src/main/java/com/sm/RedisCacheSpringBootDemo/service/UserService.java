package com.sm.RedisCacheSpringBootDemo.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.sm.RedisCacheSpringBootDemo.entity.User;

@Service
public interface UserService {

	void saveUser(User emp);
	User getOneUser(Integer id);
    void updateUser(User emp);
    Map<Integer, User> getAllUser();
    void deleteUser(Integer id);
    void saveAllEmployees(Map<Integer, User> map);
}
