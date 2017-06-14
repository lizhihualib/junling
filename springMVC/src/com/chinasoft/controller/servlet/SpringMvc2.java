package com.chinasoft.controller.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

/**
 * springMVC框架 
 * 		取代servlet，代替contoller层
 * 		springMvc通过拦截serlvet请求，实现代替servlet
 * 
 * @author Administrator
 *
 */
public class SpringMvc2 implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("==============="+request.getParameter("cmd"));
		
		
		ModelAndView modelAndView=new ModelAndView("forward:/index.jsp");
		
	
		return modelAndView;
	}

	

}
