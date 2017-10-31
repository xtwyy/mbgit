package com.wyy.mclub.service;

import java.util.List;

import com.wyy.mclub.model.DailyRecordsInfo;
import com.wyy.mclub.model.MbasicDataInfo;

public interface IBasicDataService {
//	int insertBasicData(DailyRecordsInfo dailyRecords); 
//	DailyRecordsInfo getRecordsByDay(String recordDay);  
//	
//	List<DailyRecordsInfo> getRecords();  
	
	int insertBasicData(MbasicDataInfo dailyRecord); 
	int updateBasicData(MbasicDataInfo record);
	int getMdaysByUserID(String userid); 

}
