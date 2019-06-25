package com.suo.vue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class ViewController {
	
	
	
	@RequestMapping("/{view}")
	public String view(@PathVariable("view") String view) {
		System.out.println(view);
		return view;
	}
}
