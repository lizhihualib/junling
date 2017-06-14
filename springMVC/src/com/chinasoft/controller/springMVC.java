package com.chinasoft.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.bean.Login;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/spring")
public class springMVC {
	@RequestMapping("/toIndex")
	public String toIndex(Model model,HttpServletRequest req){
		model.addAttribute("username", "张三");
		req.setAttribute("pwd", "abc123");
		return "view/index";
	}
	@RequestMapping("/toMain")
	public String toMain(){
		return "view/main";
	}	
	@RequestMapping("/query")
	public void query(HttpServletRequest req,HttpServletResponse resp){
		
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public void login(String name,@RequestParam(name="pwd") String password,@RequestParam(required=false) String checkcode){
		System.out.println("login");
		System.out.println(name+"  "+password+"  "+checkcode);
	}
	
	@RequestMapping(value="/login1",method=RequestMethod.POST)
	public void login1(Login login){
		System.out.println("login1");
		System.out.println(login.getId()+" "+login.getName()+"  "+login.getPwd()+"  "+login.getCheckcode());
		
		//执行service	
	}
	
	@RequestMapping(value="/login2",method=RequestMethod.POST)
	public void login2(Login login,HttpServletResponse resp) throws IOException{
		System.out.println("login2");
		System.out.println(login.getId()+" "+login.getName()+"  "+login.getPwd()+"  "+login.getCheckcode());
		
		//执行service	
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println("{\"code\":1,\"result\":\"登录成功\"}");
	}
	
	@RequestMapping(value="/login3",method=RequestMethod.POST)
	@ResponseBody
	public  List<Login> login3(Login login){
		System.out.println(login.getId()+" "+login.getName()+"  "+login.getPwd()+"  "+login.getCheckcode());
		
		List<Login> list=new ArrayList<Login>();
		for (int i = 0; i < 4; i++) {
			Login lo=new Login();
			lo.setId(i);
			lo.setName("name"+i);
			list.add(lo);
		}
		
		return list;
	}
	
	@RequestMapping(value="/login4",method=RequestMethod.POST)
	@ResponseBody
	public  String login4(Login login) throws JsonProcessingException{
		System.out.println(login.getId()+" "+login.getName()+"  "+login.getPwd()+"  "+login.getCheckcode());
		
		List<Login> list=new ArrayList<Login>();
		for (int i = 0; i < 4; i++) {
			Login lo=new Login();
			lo.setId(i);
			lo.setName("name"+i);
			list.add(lo);
		}
//		ObjectMapper mapper=new  ObjectMapper();
//		Map map = new HashMap();
//		map.put("list", list);		
//		String json0=mapper.writeValueAsString(map);
//		System.out.println(json0);
		
		JSONObject obj=new JSONObject();
		obj.put("list", list);
		String json=obj.toString();
		System.out.println(json);
		return json;
	}
}
