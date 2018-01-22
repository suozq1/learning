package com.lenovo.onsite.user.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenovo.onsite.common.dto.UserDTO;

@RestController
public class UserController {
    
	@RequestMapping("/user/{name}")
	public UserDTO getUser(@PathVariable("name") String name){
		UserDTO u = new UserDTO();
		u.setName("王媛媛");
		u.setAge(18);
		u.setGender(0);
		return u;
	}
}
