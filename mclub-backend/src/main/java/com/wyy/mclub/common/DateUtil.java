package com.wyy.mclub.common;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.wyy.mclub.common.DateUtil.DateFormatType;

public class DateUtil {


	public enum DateFormatType {
		/**
		 * 格式为：yyyy-MM-dd HH:mm:ss
		 */
		DATE_FORMAT_STR("yyyy-MM-dd HH:mm:ss"),
		/**
		 * 格式为：yyyyMMddHHmmss
		 */
		SIMPLE_DATE_TIME_FORMAT_STR("yyyyMMddHHmmss"),

		/**
		 * 格式为：yyyyMMddHHmmsssss
		 */
		SIMPLE_DATE_TIME_MICROSECONDS_FORMAT_STR("yyyyMMddHHmmsssss"),
		
		/**
		 * 格式为：yyyy-MM-dd
		 */
		SIMPLE_DATE_FORMAT_STR("yyyy-MM-dd"),

		/**
		 * 格式为：yyyyMMdd
		 */
		SIMPLE_DATE_FORMAT_COMMON_STR("yyyyMMdd"),
		
		/**
		 * 格式为：yyyyMMdd
		 */
		SIMPLE_DATE_FORMAT_YEAR_MON("yyyyMM"),
		
		/**
		 * 格式为：yyyy/MM/dd
		 */
		SIMPLE_DATE_FORMAT_VIRGULE_STR("yyyy/MM/dd"),

		/**
		 * 格式为：HH:mm:ss
		 */
		HOUR_MINUTE_SECOND("HH:mm:ss"),

		/**
		 * 格式为：yyyy-MM
		 */
		YEAR_MONTH_STR("yyyy-MM"),
		
		/**
		 * 格式为：HH:mm
		 */
		HOUR_MINUTE("HH:mm");

		private final String value;

		DateFormatType(String formatStr) {
			this.value = formatStr;
		}

		public String getValue() {
			return value;
		}
	}
	
	public enum TimeFormatType {

		YEAR(1), MONTH(2), DAY(5), HOUR(11), MINUTE(12), SECOND(13);
		private final int value;

		TimeFormatType(int formatStr) {
			this.value = formatStr;
		}

		public int getValue() {
			return value;
		}
	}
	
	/**
	 * 获取当前系统时间(原始格式)
	 */
	public static Date getCurrentDate() {
		Date date = new Date(System.currentTimeMillis());
		return date;
	}
	
	/**
	 * 获取当前日期的年、月、日、时、分、秒
	 */
	public static int getCurrentTime(TimeFormatType timeFormatType) {
		return getTime(getCurrentDate(), timeFormatType);
	}
	
	/**
	 * 获取指定日期的年、月、日、时、分、秒
	 */
	public static int getTime(Date date, TimeFormatType timeFormatType) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int type = timeFormatType.getValue();
			int i = c.get(type);
			return type == 2 ? i + 1 : i;
		} catch (Exception e) {
			throw new RuntimeException("获取失败", e);
		}
	}
	
	/**
	 * 获取当前时间日期的字符串
	 */
	public static String getCurrentDateStr(DateFormatType dateFormatType) {
		Date date = getCurrentDate();
		return (String) OpearationDate(date, dateFormatType.getValue());
	}

	/**
	 * 时间、日期格式化成字符串
	 */
	public static String formatDate(Date date, DateFormatType dateFormatType) {
		return (String) OpearationDate(date, dateFormatType.getValue());
	}

	/**
	 * 从字符串解析成时间、日期
	 */
	public static Date parseDate(String dateStr, DateFormatType dateFormatType) {
		return (Date) OpearationDate(dateStr, dateFormatType.getValue());
	}
	

	
	public static String calendarDays(String dateStr, int intervalDays,DateFormatType dateFoarmatType) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(dateFoarmatType.getValue());  
		Date date = sdf.parse(dateStr);
    	Calendar c = Calendar.getInstance();  
    	c.setTime(date);  
    	c.add(Calendar.DATE, intervalDays); 
    	return sdf.format(c.getTime()); 
	}
	
	
	
	private static Object OpearationDate(Object object, String formatStr) {
		if (object == null || null == formatStr || "".equals(formatStr)) {
			throw new RuntimeException("参数不能为空");
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			if (object instanceof Date)
				return format.format(object);
			else
				return format.parse(object.toString());
		} catch (Exception e) {
			throw new RuntimeException("操作失败", e);
		}
	}
	
	
	
	
	
	public static void main(String args[]){

//		try {
//			String result = calendarDays("2017-09-28 19:30:56",-1,DateFormatType.DATE_FORMAT_STR);
//			System.out.println(result);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		System.out.println("20171023".compareTo("20171021"));
//		System.out.println("20171023".compareTo("20171023"));
//		System.out.println("20171023".compareTo("20171024"));
//		System.out.println("20171023".compareTo("20161023"));
//		System.out.println("20171023".compareTo("20181023"));
//		String startDay="20171001";
//		String endDay="20171030";
//		String record_ovulationDay ="20170901";
//		
//		boolean t =(record_ovulationDay.compareTo(startDay) >= 0 && record_ovulationDay.compareTo(endDay) <=0);
//		System.out.println(t);
		
		
	}
	
	
	
}

