package com.dayuanit.mall.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dayuanit.mall.daomain.User;
import com.dayuanit.mall.mapper.UserMapper;

@ContextConfiguration("/spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
	
	private User user;
	
	@Before
	public void init() {
		user = new User();
		user.setUserName("1");
		user.setPassword("1");
		user.setEmail("1");
		
	}
	
	@Test
	@Rollback
	public void testAddUser() {
		int rows = userMapper.addUser(user);
		assertEquals(1, rows);
	}
	
	@Test
	@Rollback
	public void testGetUaerByName() {
		userMapper.addUser(user);
		User queryUser = userMapper.getUserByName(user.getUserName());
		assertEquals(queryUser.getUserName(), user.getUserName());
	}
}
