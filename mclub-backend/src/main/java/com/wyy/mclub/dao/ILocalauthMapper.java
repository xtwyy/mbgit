package com.wyy.mclub.dao;

import com.wyy.mclub.model.Localauth;

public interface ILocalauthMapper {
//    int deleteByPrimaryKey(String userid);

    int insert(Localauth record);

//    int insertSelective(Localauth record);

    Localauth selectByUserid(String userid);
    Localauth selectByLoginName(String loginname);

//    int updateByPrimaryKeySelective(Localauth record);

//    int updateByPrimaryKey(Localauth record);
}