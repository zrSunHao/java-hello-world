package com.sun.helloworld.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.helloworld.bean.User;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

	@Value(value = "${ronconn.secret}")
	private String secret;
	
	@Value(value = "${ronconn.number}")
	private int number;
	
	@Value(value = "${ronconn.name}")
	private String myName;
	
	@Value(value = "${ronconn.desc}")
	private String myDesc;

	@RequestMapping(value = "")
	public String index() {
		
		//throw new RuntimeException("测试异常");
		
		return "Hello World!";
	}

	@RequestMapping(value = "get")
	public Map<String, Object> get(@RequestParam String name) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("name", name);
		map.put("secret", secret);
		map.put("number", number);
		map.put("myName", myName);
		map.put("desc", myDesc);
		map.put("value", "Hello World!");

		System.out.println(new Date());
		
		return map;
	}

	@RequestMapping(value = "find/{id}/{name}")
	public User find(@PathVariable int id, @PathVariable String name) {

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date());

		return user;
	}

}
