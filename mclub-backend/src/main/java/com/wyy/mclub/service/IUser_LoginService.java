package com.wyy.mclub.service;

import java.util.List;

import com.wyy.mclub.model.DailyRecordsInfo;
import com.wyy.mclub.model.Localauth;
import com.wyy.mclub.model.MbasicDataInfo;
import com.wyy.mclub.model.Users;

public interface IUser_LoginService {

	 int insertUser(Users record);
    Users selectUserByUserid(String userid);
    Users selectByUserid3(String userid3);

    int updateByPrimaryKeySelective(Users record);
    
    int insertLocalauth(Localauth record);


  Localauth selectLaByUserid(String userid);
  Localauth selectByLoginName(String loginname);

}
