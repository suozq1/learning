package com.lenovo.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lenovo.springboot.entity.User;

public interface UserService {
	public void addUser(User user);
	public List<User> getUserByName(String name);
	List<User> getUserList(User user);
	Page<User> getUserWithPage(User user, Pageable pageable);
}
