package com.wyy.mclub.service;

import java.util.List;

import com.wyy.mclub.model.MrecordsInfo;

public interface IMRecordsInfoService {
	
	int insertMReordsds(MrecordsInfo mRecord); 
	int updateMReordsds(MrecordsInfo mRecord);
	int endMReordsds(MrecordsInfo mRecord);
	
	List<MrecordsInfo> getMRecords(String userId,String startDay,String endDay);  

}
