package com.lenovo.onsite.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenovo.onsite.common.dto.UserDTO;
@RefreshScope
@RestController
public class UserController {
    
	@Value("${hello.world.name}")
	private String name;
	
	@RequestMapping("/user/{name}")
	public UserDTO getUser(@PathVariable("name") String name){
		UserDTO u = new UserDTO();
		System.err.println(this.name);
		u.setName(name);
		u.setAge(18);
		u.setGender(0);
		return u;
	}
}
