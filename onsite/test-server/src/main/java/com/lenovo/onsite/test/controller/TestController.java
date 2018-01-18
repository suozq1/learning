package com.lenovo.onsite.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenovo.onsite.common.Response;
import com.lenovo.onsite.test.service.UserService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	public Response hello(String name){
		Response r = new Response(0);
		r.setData(userService.get(name));
		return r;
	}
}
