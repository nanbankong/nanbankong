package com.dayuanit.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayuanit.mall.daomain.Goods;
import com.dayuanit.mall.daomain.OrderDetail;
import com.dayuanit.mall.daomain.Orders;
import com.dayuanit.mall.exception.MALLException;
import com.dayuanit.mall.mapper.GoodsMapper;
import com.dayuanit.mall.mapper.OrderDetailMapper;
import com.dayuanit.mall.mapper.OrdersMapper;
import com.dayuanit.mall.service.OrdersService;
import com.dayuanit.mall.util.MoneyUtils;
import com.dayuanit.mall.vo.OrdersVO;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public void addOrders(OrdersVO ordersVO) {
		// TODO Auto-generated method stub
		
	}

	public static class BuyGoodDetail {
		private Goods good;
		private int quantity;
		public Goods getGood() {
			return good;
		}
		public void setGood(Goods good) {
			this.good = good;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
	}

	@Override
	public List<BuyGoodDetail> createOrderFormCard(String buyMsg, int userId) {
		String[] goods = buyMsg.split("\\$");
		List<BuyGoodDetail> gds = new ArrayList<BuyGoodDetail>();
		
		for (String goodMsg : goods) {
			if (StringUtils.isBlank(goodMsg)) {
				continue;
			}
			
			String[] goodDetails = goodMsg.split("\\-");
			//校验商品
			Goods good = goodsMapper.getGoodsById(Integer.valueOf(goodDetails[0]));
			if (null == good) {
				throw new MALLException("商品不存在");
			}
			
			if (good.getStatus() == 2) {
				throw new MALLException("商品已经下架");
			}
			
			if (good.getNumber().intValue() < Integer.parseInt(goodDetails[1])) {
				throw new MALLException("商品库存不够");
			}
			
			//先生成order 再生成订单详情
			BuyGoodDetail gd = new BuyGoodDetail();
			gds.add(gd);
			
			gd.setGood(good);
			gd.setQuantity(Integer.parseInt(goodDetails[1]));
		}
		
		processOrderDetail(gds, userId);
		
		return gds;
	}
	
	private void processOrderDetail(List<BuyGoodDetail> gds, int userId) {
		//先生成订单
		Orders orders = new Orders();
		orders.setOrderFrom(2);
		orders.setStatus(0);
		orders.setUserId(userId);
		
		String totalAmount = "0";
		for (BuyGoodDetail gd : gds) {
			String amount = MoneyUtils.mul(String.valueOf(gd.getQuantity()), String.valueOf(gd.getGood().getPrice()));
			totalAmount = MoneyUtils.plus(amount, totalAmount);
		}
		
		orders.setAmount(totalAmount);
		int rows = ordersMapper.addOrders(orders);
		if (1 != rows) {
			throw new MALLException("创建订单失败");
		}
		
		for (BuyGoodDetail gd : gds) {
			OrderDetail detail = new OrderDetail();
			String amount = MoneyUtils.mul(String.valueOf(gd.getQuantity()), String.valueOf(gd.getGood().getPrice()));
			detail.setAmount(amount);
			detail.setGoodId(gd.getGood().getId());
			detail.setGoodName(gd.getGood().getGoodsName());
			detail.setOrderId(orders.getId());
			detail.setQuantity(gd.getQuantity());
			detail.setUnitPrice(String.valueOf(gd.getGood().getPrice()));
			rows = orderDetailMapper.save(detail);
			if (1 != rows) {
				throw new MALLException("创建订单失败");
			}
		}
		
	}	
}
