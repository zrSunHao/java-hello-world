package com.sun.helloworld;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.sun.helloworld.util.filter.CustomerFilter;
import com.sun.helloworld.util.listeners.CustomerListener;
import com.sun.helloworld.util.servlet.CustomerServlet;

@SpringBootApplication
public class HelloWorldApplication implements ServletContextInitializer{

	/**
//	 * 自定义Servlet
//	 */
//	@Bean
//	public ServletRegistrationBean<CustomerServlet> servletRegistrationBean() {
//		return new ServletRegistrationBean<CustomerServlet>(new CustomerServlet(), "/roncoo");
//	}
//
//	/**
//	 * 自定义Filter
//	 */
//	@Bean
//	public FilterRegistrationBean<CustomerFilter> filterRegistrationBean() {
//		
//		//只对Servlet生效
//		//return new FilterRegistrationBean<CustomerFilter>(new CustomerFilter(),servletRegistrationBean());
//		return new FilterRegistrationBean<CustomerFilter>(new CustomerFilter());
//	}
//	
//	/**
//	 * 自定义Listener
//	 */
//	@Bean
//	public ServletListenerRegistrationBean<CustomerListener> servletListenerRegistrationBean() {
//		return new ServletListenerRegistrationBean<CustomerListener>(new CustomerListener());
//	}
//	
	
	/**
	 * Servlet、Filter、Listener的另一种注册方式
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		servletContext.addServlet("CustomerServlet", new CustomerServlet()).addMapping("/roncoo");
		
		servletContext.addFilter("CustomerFilter", new CustomerFilter())
			.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "CustomerServlet");
		
		servletContext.addListener(new CustomerListener());
	}
	

	// 整个项目的入口
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
