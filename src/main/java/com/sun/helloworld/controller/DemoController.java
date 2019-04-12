package com.sun.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.helloworld.entity.tmp_gpsinfo;
import com.sun.helloworld.service.tmp_gpsinfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "demo测试")
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    tmp_gpsinfoService service;

    @ApiOperation(value = "查询Gps信息" ,  notes="查询Gps信息")
    @RequestMapping(value="/demo/{number}" ,method=RequestMethod.GET)
    public tmp_gpsinfo demo(@PathVariable String number) {
        return service.getGpsinfo(number);
    }
}