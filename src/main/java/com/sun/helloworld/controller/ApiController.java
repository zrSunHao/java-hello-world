package com.sun.helloworld.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "api测试")
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@ApiOperation(value = "获取信息" ,  notes="测试用")
	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public HashMap<String, Object> get(@RequestParam String name) {
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;
		
	}
}
