package com.wyy.mclub.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyy.mclub.dao.ILocalauthMapper;
import com.wyy.mclub.dao.IMbasicDataInfoMapper;
import com.wyy.mclub.dao.IUsersMapper;
import com.wyy.mclub.model.Localauth;
import com.wyy.mclub.model.Users;
import com.wyy.mclub.service.IUser_LoginService;
@Service("user_loginService")
public class User_LoginServiceImpl implements IUser_LoginService {
	
	@Autowired
	private ILocalauthMapper localAuthMapper;
	@Autowired
	private IUsersMapper userMapper;

	public int insertUser(Users record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}

	public Users selectByUserid(String userid) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserid(userid);
	}

	public Users selectByUserid3(String userid3) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserid3(userid3);
	}

	public int updateByPrimaryKeySelective(Users record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}

	public Users selectUserByUserid(String userid) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserid(userid);
	}

	public int insertLocalauth(Localauth record) {
		// TODO Auto-generated method stub
		return localAuthMapper.insert(record);
	}

	public Localauth selectLaByUserid(String userid) {
		// TODO Auto-generated method stub
		return localAuthMapper.selectByUserid(userid);
	}

	public Localauth selectByLoginName(String loginname) {
		// TODO Auto-generated method stub
		return localAuthMapper.selectByLoginName(loginname);
	}

}
