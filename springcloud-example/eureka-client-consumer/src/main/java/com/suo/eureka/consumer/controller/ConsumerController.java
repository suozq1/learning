package com.suo.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/hello/{name}")
	public String test(@PathVariable("name") String name){
		return restTemplate.getForObject("http://EUREKA-PROVIDER/hello/"+name, String.class);
	}
}
