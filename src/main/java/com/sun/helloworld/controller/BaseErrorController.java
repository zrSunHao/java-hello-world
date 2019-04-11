package com.sun.helloworld.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "error")
public class BaseErrorController implements ErrorController{
	
	@Override
	public String getErrorPath() {
		// TODO 自动生成的方法存根
		
		String errMsgHtml = "<h2>404 -- Not Found!</h2>";
		String noticeMsgHtml = "<h3>If you have any questions, please contact the administrator.</h3>";
		String statementMegHtml = "<h5>By Hello World Project Api! ------ sunhao</h5>";
		
		return errMsgHtml + noticeMsgHtml + statementMegHtml;
	}
	
	@RequestMapping
	public String error() {
		return getErrorPath();
	}
}
