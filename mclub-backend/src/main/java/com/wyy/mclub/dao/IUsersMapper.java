package com.wyy.mclub.dao;

import com.wyy.mclub.model.Users;

public interface IUsersMapper {
//    int deleteByPrimaryKey(String userid);

    int insert(Users record);

//    int insertSelective(Users record);

    Users selectByUserid(String userid);
    Users selectByUserid3(String userid3);

    int updateByPrimaryKeySelective(Users record);

//    int updateByPrimaryKey(Users record);
}