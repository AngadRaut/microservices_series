package com.userService.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UsersServiceApplication {
	public static final Logger log = LoggerFactory.getLogger(UsersServiceApplication.class);
	public static void main(String[] args) {
		log.info("Application Started!!!!");
		SpringApplication.run(UsersServiceApplication.class, args);
	}
}