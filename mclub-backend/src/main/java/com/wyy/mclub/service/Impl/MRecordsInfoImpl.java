package com.wyy.mclub.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyy.mclub.common.DateUtil;
import com.wyy.mclub.common.DateUtil.DateFormatType;
import com.wyy.mclub.dao.IMrecordsInfoMapper;
import com.wyy.mclub.model.MrecordsInfo;
import com.wyy.mclub.service.IMRecordsInfoService;

@Service("mRecordsService")
public class MRecordsInfoImpl implements IMRecordsInfoService {

	@Autowired
	private IMrecordsInfoMapper mRecordsInfoMapper;
	public int insertMReordsds(MrecordsInfo mRecord) {
		// TODO Auto-generated method stub
		return mRecordsInfoMapper.insertMrecords(mRecord);
	}

	public int updateMReordsds(MrecordsInfo mRecord) {
		// TODO Auto-generated method stub
		return mRecordsInfoMapper.updateMrecords(mRecord);
	}
	
	public int endMReordsds(MrecordsInfo mRecord) {
		// TODO Auto-generated method stub
		System.out.println(mRecord.getEndday()+"----");
		return mRecordsInfoMapper.endMrecords(mRecord);
	}

	public List<MrecordsInfo> getMRecords(String userId,String startDay,String endDay) {
		// TODO Auto-generated method stub
		
		
		return mRecordsInfoMapper.getMRecords(userId,DateUtil.parseDate(startDay, DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR), DateUtil.parseDate(endDay, DateFormatType.SIMPLE_DATE_FORMAT_COMMON_STR));
	}

}
