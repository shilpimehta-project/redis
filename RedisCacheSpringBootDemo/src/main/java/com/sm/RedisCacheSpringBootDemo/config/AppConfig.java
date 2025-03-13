package com.sm.RedisCacheSpringBootDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.sm.RedisCacheSpringBootDemo.entity.User;

@Configuration
public class AppConfig {

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory();
	}
	
	public RedisTemplate<String,User> redisTemplate(){
		RedisTemplate<String,User> userTemplate=new RedisTemplate<>();
		userTemplate.setConnectionFactory(redisConnectionFactory());
		return userTemplate;
	}

}