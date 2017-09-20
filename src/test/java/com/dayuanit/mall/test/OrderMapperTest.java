package com.dayuanit.mall.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dayuanit.mall.daomain.Order;
import com.dayuanit.mall.mapper.OrderMapper;

@ContextConfiguration("/spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class OrderMapperTest {

	@Autowired
	private OrderMapper orderMapper;
	
	private Order order;
	
	@Before
	public void init() {
		order = new Order();
		order.setUserId(1);
		order.setGoodsId(1);
		order.setPrice(10.0);
		order.setGoodsNum(10);
		order.setTotal(20.0);
		order.setStatus(1);
		order.setTips("号");
		order.setSource("xx");
		order.setProvince("xx");
		order.setCity("xx");
		order.setArea("xx");		
	}
	
	@Test
	@Rollback
	public void testAddOrder() {
		int rows = orderMapper.addOrder(order);
		assertEquals(1, rows);
	}
	
//	@Test
//	@Rollback
//	public void testListOrder() {
//		orderMapper.addOrder(order);
//		List<Order> listOrder = orderMapper.listOrder(order.getUserId());
//		assertEquals(1, listOrder.size());
//	}
	
	@Test
	@Rollback
	public void testListOrder() {
		orderMapper.addOrder(order);
		List<Order> listOrder = orderMapper.listOrder(order.getUserId(), null);
		assertEquals(1, listOrder.size());
	}
}
