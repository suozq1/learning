package com.lenovo.onsite.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenovo.onsite.common.Response;
import com.lenovo.onsite.test.service.UserService;

@RestController
@Configuration
@RequestMapping("/test")
@RefreshScope
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@Value("${config.test.name}")
	private String name;
	
	@RequestMapping("/hello")
	public Response hello(String name){
		Response r = new Response(0);
		if(name==null||name.equals("")){
			name=this.name;
		}
		r.setData(userService.get(name));
		return r;
	}
}
