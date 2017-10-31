package com.wyy.mclub.common;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import com.wyy.mclub.controller.Login;

public class Utils {
	
	public static final Logger logger = Logger.getLogger(Utils.class.toString());
	
	public static void jsonResponse(String result,HttpServletResponse response) throws IOException{
		if(result.equals("")){ //为空则返回成功
			result = "{\"code\":\"0\",\"msg\":\"操作成功\"}"; 
		}else{
			logger.info("Query result:" + result);
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().print(result);
	}
}
