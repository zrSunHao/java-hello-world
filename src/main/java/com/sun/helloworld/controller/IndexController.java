package com.sun.helloworld.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.helloworld.entity.temp_user;
import com.sun.helloworld.service.userService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "起始")
@RestController
@RequestMapping(value = "/index")
public class IndexController {

	@Autowired
	userService userService;

	@Value(value = "${ronconn.secret}")
	private String secret;

	@Value(value = "${ronconn.number}")
	private int number;

	@Value(value = "${ronconn.name}")
	private String myName;

	@Value(value = "${ronconn.desc}")
	private String myDesc;

	@ApiOperation(value = "导语", notes = "导语")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {

		// throw new RuntimeException("测试异常");

		return "Hello World!";
	}

	@ApiOperation(value = "测试用", notes = "测试接口")
	@RequestMapping(value = "get", method = RequestMethod.GET)
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

	@ApiOperation(value = "查找用户", notes = "并不涉及数据库操作，只是将传入的数据封装后返回回来")
	@RequestMapping(value = "find/{id}/{name}", method = RequestMethod.GET)
	public temp_user find(@PathVariable int id, @PathVariable String name) {

		temp_user user = new temp_user();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date());

		return user;
	}

	@ApiOperation(value = "查询用户", notes = "根据Id查询")
	@RequestMapping(value = "getUser", method = RequestMethod.GET)
	public temp_user getUser(@RequestParam int id) {
		return userService.getUser(id);
	}

	@ApiOperation(value = "创建用户", notes = "创建用户")
	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public int createUser(@RequestBody temp_user user) {

//		temp_user user = new temp_user();
//		user.setId(id);
//		user.setName(name);
//		user.setDate(new Date());
//		System.out.println(name);

		return userService.createUser(user);
	}

	@ApiOperation(value = "删除用户信息", notes = "删除用户信息")
	@RequestMapping(value = "deleteUser", method = RequestMethod.GET)
	public int delete(@RequestParam int id) {
		return userService.delete(id);
	}

	@ApiOperation(value = "修改用户信息", notes = "更新用户信息")
	@RequestMapping(value = "updateUser", method = RequestMethod.GET)
	public int update(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name) {

		return userService.update(id, name);
	}

}
