package com.wyy.mclub.dao;

import com.wyy.mclub.model.MbasicDataInfo;

public interface IMbasicDataInfoMapper {
//    int deleteByPrimaryKey(String userid);
//
    int insertBasicData(MbasicDataInfo record);
    
    int updateBasicData(MbasicDataInfo record);
    byte selectMdaysByUserid(String userid);
    MbasicDataInfo selectByPrimaryKey(String userid);
    
//
//    int insertSelective(MbasicDataInfo record);
//
//    MbasicDataInfo selectByPrimaryKey(String userid);
//
//    int updateByPrimaryKeySelective(MbasicDataInfo record);
//
//    int updateByPrimaryKey(MbasicDataInfo record);
}