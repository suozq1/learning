package com.suo.eureka.provider.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/{name}")
	private String helloName(@PathVariable String name){
		return "Hello "+name;
	}
}
