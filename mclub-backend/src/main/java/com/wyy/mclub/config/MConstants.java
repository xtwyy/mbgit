package com.wyy.mclub.config;

import java.io.Serializable;
public class MConstants extends BasePropConfig implements Serializable{
	 private static final long serialVersionUID = 3302201308131761197L;
	 public static String TYPE_MSTATUS="";             
	 public static String TYPE_LOVE="";                
	 public static String TYPE_OVULATION="";           
	 public static String TYPE_LEUCORRHEA="";          
	 public static String TYPE_TEMPERATURE="";         
	 public static String TYPE_WEIGHT="";              
	 public static String TYPE_MOOD="";                
	 public static String TYPE_HABIT="";               
	 public static String TYPE_UNCOMFORTABLE="";       
	 public static String TYPE_DIARY="";               
	    //可以添加更多的静态变量

	    //这个方法是重写父类的，解析文件后会自动调用
	    public void parseConfigProperties() {
	        //文件配置覆盖默认的值
	        System.out.println("load MConstants parseConfigProperties");

	        TYPE_MSTATUS=get("TYPE_MSTATUS",EMPTY_STR);
	        TYPE_LOVE=get("TYPE_LOVE",EMPTY_STR);
	        
	        TYPE_OVULATION = get("TYPE_OVULATION",EMPTY_STR);
	        TYPE_LEUCORRHEA = get("TYPE_LEUCORRHEA",EMPTY_STR);
	        TYPE_TEMPERATURE = get("TYPE_TEMPERATURE",EMPTY_STR);
	        TYPE_WEIGHT = get("TYPE_WEIGHT",EMPTY_STR);
	        TYPE_MOOD = get("TYPE_MOOD",EMPTY_STR);
	        TYPE_HABIT = get("TYPE_HABIT",EMPTY_STR);
	        
	        TYPE_UNCOMFORTABLE = get("TYPE_UNCOMFORTABLE",EMPTY_STR);
	        TYPE_DIARY = get("TYPE_DIARY",EMPTY_STR);
	        
	        System.out.println("TYPE_LOVE"+TYPE_LOVE);
	        
	    }
	
	
	
}
