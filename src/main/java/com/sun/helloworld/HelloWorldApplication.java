package com.sun.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.sun.helloworld.util.filter.CustomerFilter;
import com.sun.helloworld.util.servlet.CustomerServlet;

@SpringBootApplication
public class HelloWorldApplication {

	/**
	 * 自定义Servlet
	 */
	@Bean
	public ServletRegistrationBean<CustomerServlet> servletRegistrationBean() {
		return new ServletRegistrationBean<CustomerServlet>(new CustomerServlet(), "/roncoo");
	}

	/**
	 * 自定义Filter
	 */
	@Bean
	public FilterRegistrationBean<CustomerFilter> filterRegistrationBean() {
		
		//只对Servlet生效
		//return new FilterRegistrationBean<CustomerFilter>(new CustomerFilter(),servletRegistrationBean());
		return new FilterRegistrationBean<CustomerFilter>(new CustomerFilter());
	}

	// 整个项目的入口
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
