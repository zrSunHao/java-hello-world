package com.sun.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.sun.helloworld.util.servlet.CustomerServlet;

@SpringBootApplication
public class HelloWorldApplication {

	@Bean
	public ServletRegistrationBean<CustomerServlet> servletRegistrationBean() {
		return new ServletRegistrationBean<CustomerServlet>(new CustomerServlet(),"/roncoo");
	}
	
	//整个项目的入口
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
