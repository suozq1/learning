package com.lenovo.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lenovo.springboot.dao.UserDao;
import com.lenovo.springboot.entity.User;
import com.lenovo.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserDao userDao;
	
	public void addUser(User user) {
		userDao.save(user);
	}

	public List<User> getUserByName(String name) {
		return userDao.findByUserName(name);
	}
	@Override
	public List<User> getUserList(User user){
		Example<User> ex=Example.of(user);
		return userDao.findAll(ex);
	}
	@Override
	public Page<User> getUserWithPage(User user,Pageable pageable){
		Example<User> ex=Example.of(user);
		return userDao.findAll(ex, pageable);
	}

}
