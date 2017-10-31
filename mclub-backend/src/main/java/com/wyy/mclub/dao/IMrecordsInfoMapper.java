package com.wyy.mclub.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wyy.mclub.model.MrecordsInfo;

public interface IMrecordsInfoMapper {
//    int deleteByPrimaryKey(Integer seq);
//
    int insertMrecords(MrecordsInfo record);
//
//    int insertSelective(MrecordsInfo record);
//
//    MrecordsInfo selectByPrimaryKey(Integer seq);
//
//    int updateByPrimaryKeySelective(MrecordsInfo record);
//
    int updateMrecords(MrecordsInfo record);
    int endMrecords(MrecordsInfo record);
    List<MrecordsInfo> getMRecords(@Param("userId")String userId,@Param("startDay")Date startDay,@Param("endDay")Date endDay);
    
}