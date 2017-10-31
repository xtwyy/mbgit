package com.wyy.mclub.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wyy.mclub.model.DailyRecordsInfo;

public interface IDailyRecordsInfoMapper {
//    int deleteByPrimaryKey(Integer seq);
//
    int insert(DailyRecordsInfo record);
    int updateByDay(DailyRecordsInfo record);
    
    List<DailyRecordsInfo> getDailyRecords(@Param("userId")String userId,@Param("startDay")String startDay,@Param("endDay")String endDay);
    
    DailyRecordsInfo selectByDay(@Param("userId")String userId,@Param("recDay")String recDay);
//
//    int insertSelective(DailyRecordsInfo record);
//
//    DailyRecordsInfo selectByPrimaryKey(Integer seq);
//
//    int updateByPrimaryKeySelective(DailyRecordsInfo record);
//
//    int updateByPrimaryKey(DailyRecordsInfo record);
}