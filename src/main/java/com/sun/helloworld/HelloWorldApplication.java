package com.sun.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class HelloWorldApplication {

	// 整个项目的入口
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
