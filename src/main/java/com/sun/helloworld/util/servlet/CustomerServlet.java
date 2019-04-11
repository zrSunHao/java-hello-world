package com.sun.helloworld.util.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author x 自定义 Servlet
 */
@WebServlet(urlPatterns = "/roncoo", name = "CustomerServlet")//第三种注册方式
public class CustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servelet get method!");
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servelet post method!");
		response.getWriter().write("hello world,this is CustomerServlet!");
	}
}
