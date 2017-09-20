package com.dayuanit.mall.service;

import java.util.List;

import com.dayuanit.mall.service.impl.OrdersServiceImpl.BuyGoodDetail;
import com.dayuanit.mall.vo.OrdersVO;

public interface OrdersService {

	void addOrders(OrdersVO ordersVO);
	
	List<BuyGoodDetail> createOrderFormCard(String buyMsg, int userId);
}
