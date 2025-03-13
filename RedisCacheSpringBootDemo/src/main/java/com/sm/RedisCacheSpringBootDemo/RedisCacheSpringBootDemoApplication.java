package com.sm.RedisCacheSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCacheSpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheSpringBootDemoApplication.class, args);
	}

}
