package com.dayuanit.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayuanit.mall.daomain.Order;
import com.dayuanit.mall.daomain.User;
import com.dayuanit.mall.exception.MALLException;
import com.dayuanit.mall.mapper.OrderMapper;
import com.dayuanit.mall.mapper.UserMapper;
import com.dayuanit.mall.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;
		
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addOrder(Order order) {
		Order exitOrder = orderMapper.getOrderById(order.getId());
		if (null != exitOrder) {
			throw new MALLException("没有此订单");
		}
		
		int rows = orderMapper.addOrder(order);
		if (1 != rows) {
			throw new MALLException("加入购物车失败");
		}
	}

	@Override
	public Order getOrderById(int orderId) {
		
		return orderMapper.getOrderById(orderId);
	}

	@Override
	public List<Order> listOrder(int userId, Integer status) {
		User exitUser = userMapper.getUserById(userId);
		if (null == exitUser) {
			throw new MALLException("用户未登录");
		}
		return orderMapper.listOrder(userId, 1);
	}	
}
