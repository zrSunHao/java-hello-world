package com.sun.helloworld.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.helloworld.model.DtoRevokeCompanyPushInfo;
import com.sun.helloworld.model.RevokeOAResult;
import com.sun.helloworld.service.apiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "ApiController")
@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	apiService service;

	@ApiOperation(value = "获取信息", notes = "测试用")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public HashMap<String, Object> get(@RequestParam String name) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;

	}

	@ApiOperation(value = "新建收车公司", notes = "测试新建收车公司推送小程序用")
	@RequestMapping(value = "/createCompany", method = RequestMethod.POST)
	public RevokeOAResult createCompany(@RequestBody DtoRevokeCompanyPushInfo company) {

		return service.createCompany(company);

	}
}
