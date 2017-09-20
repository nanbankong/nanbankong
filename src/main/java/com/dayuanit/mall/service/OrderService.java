package com.dayuanit.mall.service;

import java.util.List;

import com.dayuanit.mall.daomain.Order;

public interface OrderService {
	
	void addOrder(Order order);
	
	Order getOrderById(int orderId);
	
	List<Order> listOrder(int userId, Integer status);
}
