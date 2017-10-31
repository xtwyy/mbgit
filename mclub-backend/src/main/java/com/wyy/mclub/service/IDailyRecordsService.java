package com.wyy.mclub.service;

import java.util.List;

import com.wyy.mclub.model.DailyRecordsInfo;

public interface IDailyRecordsService {
	int insert(DailyRecordsInfo dailyRecords); 
	DailyRecordsInfo getRecordsByDay(String userId,String recordDay);  
	
	List<DailyRecordsInfo> getRecords();  
	
	int insertDailyData(DailyRecordsInfo dailyRecord); 
	List<DailyRecordsInfo> getDailyRecords(String userId,String startDay,String endDay); 

}
