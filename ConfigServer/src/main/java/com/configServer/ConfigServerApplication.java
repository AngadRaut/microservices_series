package com.configServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigServerApplication {
	private static final Logger log = LoggerFactory.getLogger(ConfigServerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
		log.info("Config Server service started!!!");
	}
}