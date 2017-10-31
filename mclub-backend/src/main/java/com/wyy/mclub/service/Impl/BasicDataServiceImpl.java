package com.wyy.mclub.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyy.mclub.dao.IMbasicDataInfoMapper;
import com.wyy.mclub.model.MbasicDataInfo;
import com.wyy.mclub.service.IBasicDataService;

@Service("basicDataService")
public class BasicDataServiceImpl implements IBasicDataService {
	
	@Autowired
	private IMbasicDataInfoMapper basicDataMapper;

	public int insertBasicData(MbasicDataInfo basicData) {
		// TODO Auto-generated method stub
		return basicDataMapper.insertBasicData(basicData);
	}
	
	public int updateBasicData(MbasicDataInfo record){
		return basicDataMapper.updateBasicData(record);
	}

	public int getMdaysByUserID(String userid) {
		// TODO Auto-generated method stub
		byte mDays = basicDataMapper.selectMdaysByUserid(userid);
		return new Integer(mDays);
	}

}
