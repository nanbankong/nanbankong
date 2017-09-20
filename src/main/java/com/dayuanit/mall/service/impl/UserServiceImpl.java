package com.dayuanit.mall.service.impl;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayuanit.mall.daomain.User;
import com.dayuanit.mall.exception.MALLException;
import com.dayuanit.mall.mapper.UserMapper;
import com.dayuanit.mall.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
		
	
	@Override
	public void regist(String userName, String password, String configPassword, String email) {
		
		User exitUser = userMapper.getUserByName(userName);
		if (null != exitUser) {
			throw new MALLException("用户已存在");
		}
		
		if (!password.equals(configPassword)) {
			throw new MALLException("两次密码不相等");
		}
		
		password += userName;
		password = DigestUtils.md5Hex(password);
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		
		int rows = userMapper.addUser(user);
		if (1 != rows) {
			throw new MALLException("注册失败");
		}
	}


	@Override
	public User login(String userName, String password) {
		
		User user = userMapper.getUserByName(userName);
		if (null == user) {
			throw new MALLException("用户名不存在或者密码错误");
		}
		
		password += userName;
		password = DigestUtils.md5Hex(password);
	
		if (!user.getPassword().equals(password)) {
			throw new MALLException("用户名不存在或者密码错误");
		}
		
		return user;
	}

}
