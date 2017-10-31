package com.wyy.mclub.controller;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wyy.mclub.bean.UserBean;
import com.wyy.mclub.common.DateUtil;
import com.wyy.mclub.common.DateUtil.DateFormatType;
import com.wyy.mclub.common.Utils;
import com.wyy.mclub.model.Localauth;
import com.wyy.mclub.model.Users;
import com.wyy.mclub.service.IUser_LoginService;


@Controller
public class Login {
	
	public static final Logger logger = Logger.getLogger(Login.class.toString());
	@Autowired
	private IUser_LoginService user_loginService;
	
	
	@RequestMapping("/index")
	public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("un");
		String passWord = request.getParameter("pd");
		
		Localauth la=user_loginService.selectByLoginName(userName);
		String result = "";
		if(la == null){ //不存在，报错
			result = "{\"code\":\"1\",\"msg\":\"用户名不存在\"}";
		}else{
			String db_passWord = la.getPassword();
			if (db_passWord.equals(passWord)){
				result = "{\"code\":\"0\",\"userid\":\""+ la.getUserid() +"\",\"msg\":\"登录成功\"}";
			}else{
				result = "{\"code\":\"1\",\"msg\":\"密码错误\"}";
			}
			
		}
		 Utils.jsonResponse(result,response);
		
	}
	
	
	@RequestMapping("/login3")
	public void login3(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("un");
		String passWord = request.getParameter("pd");
		
		String result = "{\"code\":\"0\",\"msg\":\"登录成功\"}"; 
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().print(result);
		
	}
	
	@RequestMapping("/regist")
	public void newRegist(@RequestBody String registJson, HttpServletResponse response) throws Exception{
		ObjectMapper mapper = new ObjectMapper();  
        UserBean userBean = mapper.readValue(registJson, UserBean.class);
        logger.info("It is a new user registing,userid is " + userBean.getLoginname()); 
        
        Users user = new Users();
        Localauth localAuth = new Localauth();
        
        if(userBean.getBirth()!=null){
        	user.setBirth(DateUtil.parseDate(userBean.getBirth(), DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR));
        }
        if(userBean.getCurlive()!=null){
        	 user.setCurlive(userBean.getCurlive());
        }
        
        if(userBean.getHometown()!=null){
        	user.setHometown(userBean.getHometown());
        }
        
        if(userBean.getName()!=null){
        	user.setName(userBean.getName());
        }
        
        if(userBean.getNickname() != null){
        	user.setNickname(userBean.getNickname());
        }
        
        if(userBean.getPhonenumber()!=null){
        	user.setPhonenumber(userBean.getPhonenumber());
        }
        
        if(userBean.getSex()!=null){
        	user.setSex(userBean.getSex());
        }
        
        
        user.setRegdate(new Date());
        
        String source = "LOCAL";
        user.setSource(source);
        user.setUserid(source + "_" + userBean.getLoginname());
        
        user_loginService.insertUser(user);
        
        
        localAuth.setLoginname(userBean.getLoginname());
        localAuth.setPassword(userBean.getPassword());
        localAuth.setUserid(user.getUserid());
        user_loginService.insertLocalauth(localAuth);
        
        Utils.jsonResponse("",response);

	}	
	
	@RequestMapping("/checkloginname")
	public void checkLoginName(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String loginName = request.getParameter("ln");  
		Localauth la=user_loginService.selectByLoginName(loginName);
		String result = "";
		if(la == null){ //不存在，可用
			result = "{\"code\":\"0\",\"msg\":\"用户名可用\"}";
		}else{
			result = "{\"code\":\"1\",\"msg\":\"用户名已被占用\"}";
		}
		 Utils.jsonResponse(result,response);

	}
	

	
}
