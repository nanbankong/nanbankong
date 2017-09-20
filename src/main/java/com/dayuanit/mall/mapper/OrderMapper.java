package com.dayuanit.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dayuanit.mall.daomain.Order;

public interface OrderMapper {

	int addOrder(Order order);
	
	Order getOrderById(@Param("orderId") Integer orderId);
	
	List<Order> listOrder(@Param("userId") Integer userId, @Param("status") Integer status);
	
	
}
