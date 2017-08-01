package com.lenovo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lenovo.springboot.common.PageParam;
import com.lenovo.springboot.entity.User;
import com.lenovo.springboot.service.UserService;
@Controller
public class SpringbootController {
	
	@Autowired
    private UserService userService;	
	
	@ResponseBody
	@RequestMapping("/")
	public String hello(){
		return "Hello Spring Boot";
	}
	@RequestMapping("/view")
	public String viewTest(ModelMap map,String name){
		map.put("name",name);
		User user=userService.getUserByName(name).get(0);
		map.put("user",user);
		return "home";
	}
	@ResponseBody
	@RequestMapping("/user")
	public List<User> getUserList(User user){
		return userService.getUserList(user);
	}
	@ResponseBody
	@RequestMapping("/pageableUser")
	public Page<User> getUserWithPage(User user,PageParam pageParam){
		return userService.getUserWithPage(user, pageParam.getPageable());
	}
}
