package com.wyy.mclub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClassSchedule {
	@RequestMapping(value="/csetting",method = RequestMethod.POST)
	public void csetting(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("un");
		String passWord = request.getParameter("pd");
		
		String result = "{\"code\":\"1\",\"msg\":\"登录成功\"}"; 
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().print(result);
		
	}
	
	@RequestMapping("/cshowing")
	public void cshowing(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("un");
		String passWord = request.getParameter("pd");
		
		String result = "{\"code\":\"1\",\"msg\":\"登录成功\"}"; 
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().print(result);
		
	}
}
