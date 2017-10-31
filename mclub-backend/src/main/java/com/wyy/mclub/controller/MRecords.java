package com.wyy.mclub.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wyy.mclub.bean.DailysettingBean;
import com.wyy.mclub.bean.MbasicBean;
import com.wyy.mclub.bean.MshowBean;
import com.wyy.mclub.common.DateUtil;
import com.wyy.mclub.common.Utils;
import com.wyy.mclub.common.DateUtil.DateFormatType;
import com.wyy.mclub.config.MConstants;
import com.wyy.mclub.model.DailyRecordsInfo;
import com.wyy.mclub.model.MbasicDataInfo;
import com.wyy.mclub.model.MrecordsInfo;
import com.wyy.mclub.service.IBasicDataService;
import com.wyy.mclub.service.IDailyRecordsService;
import com.wyy.mclub.service.IMRecordsInfoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class MRecords {
	
	public static final Logger logger = Logger.getLogger(MRecords.class.toString());
	@Autowired
	private IDailyRecordsService dRecordsService;
	
	@Autowired
	private IBasicDataService basicDataService;
	
	@Autowired
	private IMRecordsInfoService mRecordsService;

	@RequestMapping(value="/mbasic",method = RequestMethod.POST)
	public void mBasicSetting(@RequestBody String mbasicJson, HttpServletResponse response) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();  
        MbasicBean basicBean = mapper.readValue(mbasicJson, MbasicBean.class);
        logger.info("It is a new user coming,userid is " + basicBean.getUserid()); 
        String oprType = basicBean.getOprtype();
        MbasicDataInfo basicData = new MbasicDataInfo();
        
        if(basicBean.getMcycle()!=null){
        	 basicData.setMcycle(new Byte(basicBean.getMcycle()));
        }
        
        if(basicBean.getMdays()!=null){
        	basicData.setMdays(new Byte(basicBean.getMdays()));
        }
        basicData.setPeriod(basicBean.getPeriod());
        basicData.setUserid(basicBean.getUserid());
        
        
        if(oprType.equals("add")){
        	//1.新增入基础库
            basicData.setInitime(new Date());
            basicData.setOpttime(new Date());
        	int insertR = 0;
        	try{
        		insertR = basicDataService.insertBasicData(basicData);
        	}catch(Exception ex){
        		logger.info("insert error ==" + ex.getMessage());
        	}
        	if(insertR == 0){
        		basicData.setOpttime(new Date());
            	basicDataService.updateBasicData(basicData);
        	}
        	
        	//2.根据日期入m库、
        	saveMrecords(basicBean.getUserid(),basicBean.getLastMday(),basicBean.getMdays());
               	
        }else if(oprType.equals("update")){
        	//更新基础库
        	basicData.setOpttime(new Date());
        	basicDataService.updateBasicData(basicData);
        }
		
        Utils.jsonResponse("",response);
		
	}
	
	@RequestMapping(value="/msetting",method = RequestMethod.POST)
	public void msetting(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("un");
		String passWord = request.getParameter("pd");
		
		 Utils.jsonResponse("",response);
		
	}
	
	
	public void saveMrecords(String userid,String str_startDay,String mDays) throws NumberFormatException, ParseException{
		
		int intMday = 0;
		
		if(mDays == null){ //需要查基础表取出时间
			intMday = basicDataService.getMdaysByUserID(userid);
		}else{
			intMday = new Integer(mDays);
		}

		MrecordsInfo mRecord = new MrecordsInfo();
    	mRecord.setUserid(userid);
    	
    	String endMday = DateUtil.calendarDays(str_startDay, intMday - 1, DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR);
    	String ovulationday = DateUtil.calendarDays(str_startDay, -14, DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR);
    	
    	
    	Date startDay = DateUtil.parseDate(str_startDay, DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR);
    	Date endDay = DateUtil.parseDate(endMday, DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR);
    	Date ovulationDay = DateUtil.parseDate(ovulationday, DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR);
    	
    	
    	mRecord.setStartday(startDay);
    	mRecord.setEndday(endDay);
    	mRecord.setOprtime(new Date());
    	mRecord.setOvulationday(ovulationDay);
    	
    	mRecordsService.insertMReordsds(mRecord);
	}
	
public void endMrecords(String userid,String str_endDay) throws NumberFormatException, ParseException{
		

		MrecordsInfo mRecord = new MrecordsInfo();
    	mRecord.setUserid(userid);

    	Date endDay = DateUtil.parseDate(str_endDay, DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR);
    	mRecord.setEndday(endDay);
    	mRecord.setOprtime(new Date());
    	
    	mRecordsService.endMReordsds(mRecord);
	}
	
	
	@RequestMapping(value="/dailysetting",method=RequestMethod.POST)
	public void dailysetting(@RequestBody String settingJson, HttpServletResponse response) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();  
        DailysettingBean dailyBean = mapper.readValue(settingJson, DailysettingBean.class);
        logger.info("dailysetting: " + dailyBean.getUserid() + ":" +dailyBean.getType() + ":" +dailyBean.getValue());
        
        String recDay = dailyBean.getDate();
        String type = dailyBean.getType();
        String userID = dailyBean.getUserid();
        String value = dailyBean.getValue();
        
      //save data
        DailyRecordsInfo daiyRecordsInfo = new DailyRecordsInfo();  
        daiyRecordsInfo.setRecday(recDay);//格式YYYYMMDD
        daiyRecordsInfo.setUserid(userID);
        
        if(type.equals(MConstants.TYPE_DIARY)){
        	
        	daiyRecordsInfo.setDiary(value);
        	
        }else if(type.equals(MConstants.TYPE_HABIT)){
        	daiyRecordsInfo.setHabit(value);
        	
        }else if(type.equals(MConstants.TYPE_LEUCORRHEA)){
        	daiyRecordsInfo.setLeucorrhea(value);
        	
        }else if(type.equals(MConstants.TYPE_LOVE)){
        	daiyRecordsInfo.setLove(value);
        	
        }else if(type.equals(MConstants.TYPE_MOOD)){
        	daiyRecordsInfo.setMood(value);
        	
        }else if(type.equals(MConstants.TYPE_MSTATUS)){
        	daiyRecordsInfo.setMstatus(value);
        	//M状态出发更新mrecords表
        	if(value.equals("0")){ //开始
        		//新增记录
        		saveMrecords(userID,recDay,null);
        		//更新记录
        	}else{ //结束
        		//更新小于更新日期的最后一条，前台展示结束只有开始和结束的后五天时间
        		endMrecords(userID,recDay);
        	}
        	
        }else if(type.equals(MConstants.TYPE_OVULATION)){
        	daiyRecordsInfo.setOvulation(value);
        	
        }else if(type.equals(MConstants.TYPE_TEMPERATURE)){
        	daiyRecordsInfo.setTemperature(new Double(value));
        	
        }else if(type.equals(MConstants.TYPE_UNCOMFORTABLE)){
        	daiyRecordsInfo.setUncomfortable(value);
        	
        }else if(type.equals(MConstants.TYPE_WEIGHT)){
        	daiyRecordsInfo.setWeight(new Double(value));
        	
        }else{
        	
        }
		dRecordsService.insertDailyData(daiyRecordsInfo); 

		 Utils.jsonResponse("",response);
		
	}
	
	@RequestMapping("/mshowing")
	public void mshowing(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//get 请求参数 用户名 查询月份 yyyyMM
		String userName = request.getParameter("un"); 
		String startDay = request.getParameter("sd");
		String endDay = request.getParameter("ed");
		//查询M记录表
		List<MrecordsInfo> list= mRecordsService.getMRecords(userName,startDay, endDay);
		
		Map dailyRecordsMap = new HashMap();
		
		for(int i=0;i<list.size();i++){
			MrecordsInfo record = list.get(i);
			String record_startDay = DateUtil.formatDate(record.getStartday(), DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR);
			String record_endDay = DateUtil.formatDate(record.getEndday(), DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR);
			String record_ovulationDay = DateUtil.formatDate(record.getOvulationday(), DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR);
			
			//如果日期小于开始时间或者大于结束时间，则不需要处理
			if(record_ovulationDay.compareTo(startDay) >= 0 && record_ovulationDay.compareTo(endDay) <=0){
				put2Map(record_ovulationDay,MConstants.TYPE_OVULATION,dailyRecordsMap);
			}
			
			//计算开始时间到结束时间的区间是否是m状态
			
			boolean needCalendaDays = true;
			//如果开始时间大于查询的结束时间，则不需要处理
			if(record_startDay.compareTo(endDay)>0){
				needCalendaDays = false;
			}
			
			//如果结束时间小于查询的开始时间，则不需要处理
			if(record_endDay.compareTo(startDay)<0){
				needCalendaDays = false;
			}
			
			if(needCalendaDays){
				//从开始时间算起
				
				if(record_startDay.compareTo(startDay) >= 0 && record_startDay.compareTo(endDay) <=0){
					put2Map(record_startDay,MConstants.TYPE_MSTATUS,dailyRecordsMap);
				}
				for(int j=1;j<30;j++){
					String nextDay = DateUtil.calendarDays(record_startDay, j, DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR);
					//超出结束时间则退出
					if(nextDay.compareTo(record_endDay)>0){
						break;
					}	
					if(nextDay.compareTo(startDay) >= 0 && nextDay.compareTo(endDay) <=0){
						put2Map(nextDay,MConstants.TYPE_MSTATUS,dailyRecordsMap);
					}
					
				}
				
			}
		}
		
		//查询日记录表
		List<DailyRecordsInfo> dList = dRecordsService.getDailyRecords(userName, startDay, endDay);
		for (int i=0;i<dList.size();i++){
			DailyRecordsInfo drecord = dList.get(i);
			String recDay = drecord.getRecday();
			System.out.println(recDay);
			if(drecord.getDiary()!=null){
				put2Map(recDay,MConstants.TYPE_DIARY,dailyRecordsMap);
			}
			if(drecord.getHabit()!=null){
				put2Map(recDay,MConstants.TYPE_HABIT,dailyRecordsMap);
			}
			if(drecord.getLeucorrhea()!=null){
				put2Map(recDay,MConstants.TYPE_LEUCORRHEA,dailyRecordsMap);
			}
			if(drecord.getLove()!=null){
				put2Map(recDay,MConstants.TYPE_LOVE,dailyRecordsMap);
			}
			if(drecord.getMood()!=null){
				put2Map(recDay,MConstants.TYPE_MOOD,dailyRecordsMap);
			}
			if(drecord.getTemperature()!=null){
				put2Map(recDay,MConstants.TYPE_TEMPERATURE,dailyRecordsMap);
			}
			if(drecord.getUncomfortable()!=null){
				put2Map(recDay,MConstants.TYPE_UNCOMFORTABLE,dailyRecordsMap);
			}
			if(drecord.getWeight()!=null){
				put2Map(recDay,MConstants.TYPE_WEIGHT,dailyRecordsMap);
			}

		}
		
		ObjectMapper m = new ObjectMapper();  
		String result = m.writeValueAsString(dailyRecordsMap);
		 Utils.jsonResponse(result,response);
		
	}
	
	public void put2Map(String key,String value,Map map){
		if(map.get(key) == null){
			map.put(key, value);
		}else{
			String mapValue = (String) map.get(key);
			String newValue = mapValue + ";" +value;
			map.put(key, newValue);
		}
	}
	
	
	@RequestMapping("/dshowing")
	public void dshowing(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//get 请求参数 用户名 查询月份 yyyyMM
		String userName = request.getParameter("un"); 
		String recordDay = request.getParameter("rd");
		DailyRecordsInfo dRecord= dRecordsService.getRecordsByDay(userName, recordDay);
		
		
		ObjectMapper m = new ObjectMapper();  
		String result = m.writeValueAsString(dRecord);
		 Utils.jsonResponse(result,response);
	
	}
	


}
