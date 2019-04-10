package com.sun.helloworld.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.helloworld.bean.User;

@RestController
@RequestMapping(value = "/index")
public class IndexController {
	
	@RequestMapping(value = "")
	public String index() {
		return "Hello World!";
	}
	
	@RequestMapping(value = "get")
	public Map<String, String> get(@RequestParam String name) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", name);
		map.put("value", "Hello World!");
		
		return map;
	}
	
	@RequestMapping(value = "find/{id}/{name}")
	public User find(@PathVariable int id,String name) {
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date());
		
		return user;
	}
	
}
