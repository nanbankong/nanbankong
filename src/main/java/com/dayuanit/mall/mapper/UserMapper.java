package com.dayuanit.mall.mapper;

import org.apache.ibatis.annotations.Param;

import com.dayuanit.mall.daomain.User;

public interface UserMapper {

	int addUser(User user);
	
	User getUserByName(@Param("userName") String userName);
	
	User getUserById(@Param("userId") Integer userId);
}
