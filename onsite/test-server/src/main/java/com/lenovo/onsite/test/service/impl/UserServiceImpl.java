package com.lenovo.onsite.test.service.impl;

import org.springframework.stereotype.Service;

import com.lenovo.onsite.common.dto.UserDTO;
import com.lenovo.onsite.test.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Override
	public UserDTO get(String name) {
		// TODO Auto-generated method stub
		UserDTO u=new UserDTO();
		u.setName("锁战强");
		return u;
	}

}
