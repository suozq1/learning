package com.lenovo.onsite.test.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lenovo.onsite.common.dto.UserDTO;
@FeignClient(value = "user-server")
public interface UserService {
	
	@RequestMapping(value = "/user/{name}")
	public UserDTO get(@PathVariable("name") String name);
}
