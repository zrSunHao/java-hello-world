package com.sun.helloworld.util.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author x
 * 自定义Listener
 */
public class CustomerListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("contextInitialized");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		System.out.println("contextDestroyed");
	}
}
