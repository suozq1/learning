package com.suo.eureka.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaProviderApplication {
	static Logger log=LoggerFactory.getLogger(EurekaProviderApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaProviderApplication.class, args);
	}
}
