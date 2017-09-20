package com.dayuanit.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dayuanit.mall.daomain.Order;
import com.dayuanit.mall.dto.AjaxResultDTO;
import com.dayuanit.mall.exception.MALLException;
import com.dayuanit.mall.service.OrderService;
import com.dayuanit.mall.service.OrdersService;
import com.dayuanit.mall.service.impl.OrdersServiceImpl.BuyGoodDetail;
import com.dayuanit.mall.vo.BuyGoodVO;
import com.dayuanit.mall.vo.OrderVO;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{

	Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("/toOrder")
	public String toOrder() {				
		return "order";
	}
	
	@RequestMapping("/addOrder")
	@ResponseBody
	public AjaxResultDTO addOrder(String buyMsg, HttpServletRequest req) {
		
			log.info(">>>>>>>>购物车结算数据" + buyMsg);
		
		if (StringUtils.isBlank(buyMsg)) {
			return AjaxResultDTO.failed("信息不合法");
		}
		
		List<BuyGoodDetail> dto = ordersService.createOrderFormCard(buyMsg, getUserId(req));
		
		return AjaxResultDTO.success(dto);
	}
	
	@RequestMapping("/addOrder4Json")
	@ResponseBody
	public AjaxResultDTO addOrder4Json(String buyMsg) {
		
		log.info("购买信息：{}", buyMsg);
		
		try {
			List<BuyGoodVO> voList = JSON.parseArray(buyMsg, BuyGoodVO.class);
			return AjaxResultDTO.success();
		} catch (MALLException me) {
			log.error("购买失败", me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			log.error("购买失败,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("购买失败");
		}
	}
	
	@RequestMapping("/addOrder4JsonBody")
	@ResponseBody
	public AjaxResultDTO addOrder4JsonBody(@RequestBody List<BuyGoodVO> vos) {
		log.info(">>>>" + vos.size());
		for (BuyGoodVO vo : vos) {
			log.info(">>>>>"+ vo.getGoodId());
			log.info(">>>>>"+ vo.getQuantity());
		}
		return AjaxResultDTO.success();
	}
	
	@RequestMapping("/listOrder")
	@ResponseBody
	public AjaxResultDTO listOrder(HttpServletRequest req) {
		
		try {
			
			List<Order> listOrder= orderService.listOrder(getUserId(req), null);
			log.info("=====listOrder.size={}======", listOrder.size());

			return AjaxResultDTO.success(listOrder);
		} catch (MALLException me) {
			log.error("查询订单列表异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			log.error("查询订单列表异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed(e.getMessage());
		}
	}
	
	@RequestMapping("/listOrderByStatus")
	@ResponseBody
	public AjaxResultDTO listOrderByStatus(HttpServletRequest req) {
		
		try {
			
			List<Order> listOrder= orderService.listOrder(getUserId(req), 1);
			log.info("=====listOrder.size={}======", listOrder.size());

			return AjaxResultDTO.success(listOrder);
		} catch (MALLException me) {
			log.error("查询订单列表异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			log.error("查询订单列表异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.8.105", 6379);
		String msg = jedis.get("test:redis");
		System.out.println(msg);

		JedisPool jedisPool = new JedisPool("192.168.8.105", 6379);
		jedis = jedisPool.getResource();
		String msg2 = jedis.get("test:redis");
		System.out.println(msg2);
	}
}
