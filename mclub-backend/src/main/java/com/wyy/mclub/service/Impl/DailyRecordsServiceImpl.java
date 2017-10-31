package com.wyy.mclub.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyy.mclub.common.DateUtil;
import com.wyy.mclub.common.DateUtil.DateFormatType;
import com.wyy.mclub.dao.IDailyRecordsInfoMapper;
import com.wyy.mclub.model.DailyRecordsInfo;
import com.wyy.mclub.service.IDailyRecordsService;

@Service("dRecordsService")
public class DailyRecordsServiceImpl implements IDailyRecordsService {
	
	@Autowired  
	private IDailyRecordsInfoMapper dailyRecordsInfoMapper;  


	public int insert(DailyRecordsInfo dailyRecords) {
		int result = dailyRecordsInfoMapper.insert(dailyRecords);
		return 0;
	}

	public DailyRecordsInfo getRecordsByDay(String userId,String recordDay) {
		// TODO Auto-generated method stub
//		return dailyRecordsInfoMapper.selectByDay(recordDay);
		return dailyRecordsInfoMapper.selectByDay(userId, recordDay);
	}

	public List<DailyRecordsInfo> getRecords() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int insertDailyData(DailyRecordsInfo dailyRecord){
		int result = dailyRecordsInfoMapper.updateByDay(dailyRecord);
		
		//如果update失败则新增
		
		if( result == 0){
			result = dailyRecordsInfoMapper.insert(dailyRecord);
			System.out.println("result insert == "+ result);
		}
		
		return result;
	}
	
	public List<DailyRecordsInfo> getDailyRecords(String userId,String startDay,String endDay){
		return dailyRecordsInfoMapper.getDailyRecords(userId, startDay,endDay);
	}

}
