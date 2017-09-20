package com.dayuanit.mall.service;

import com.dayuanit.mall.daomain.User;

public interface UserService {

	void regist(String userName, String password, String configPassword, String email);
	
	User login(String userName, String password);
}
