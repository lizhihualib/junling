package com.chinasoft.controller.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * springMVC框架 
 * 		取代servlet，代替contoller层
 * 		springMvc通过拦截serlvet请求，实现代替servlet
 * 
 * @author Administrator
 *
 */
public class SpringMvc3 extends MultiActionController{

	public void query(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("-------------");
	}
	public void update(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("+++++++++++++");
	}
}
