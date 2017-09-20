package com.dayuanit.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dayuanit.mall.daomain.Car;
import com.dayuanit.mall.daomain.Goods;
import com.dayuanit.mall.dto.AjaxResultDTO;
import com.dayuanit.mall.exception.MALLException;
import com.dayuanit.mall.service.CarService;
import com.dayuanit.mall.service.GoodsService;

@Controller
@RequestMapping("/car")
public class CarController extends BaseController{

	Logger log = LoggerFactory.getLogger(CarController.class);

	@Autowired
	private CarService carService;
	
	@Autowired
	private GoodsService goodsService;
		
	@RequestMapping("/toCart")
	public String toCart() {	
		return "cart";
	}
	
	@RequestMapping("/getCarGoods")
	public String getCarGoods(int goodsId, ModelMap mm) {
		try {			
			Goods goods = goodsService.getGoodsById(goodsId);
			log.info("=====goodsName={}======", goods.getGoodsName());
			Car car = carService.queryCar(goodsId);
			mm.addAttribute("goods", goods);
			mm.addAttribute("car", car);
			return "shoppingCar";
		} catch (MALLException me) {			
			throw new MALLException("获取购物车商品详情异常");
		}
	}

//	catch (MALLException me) {
//		log.error("查询收获地址异常,{}", me.getMessage(), me);
//		return AjaxResultDTO.failed(me.getMessage());
//	} catch(Exception e) {
//		log.error("查询收获地址异常,{}", e.getMessage(), e);
//		return AjaxResultDTO.failed("查询收获地址失败");
//	}
	
	@RequestMapping("/listCarGoods")
	@ResponseBody
	public AjaxResultDTO listCarGoods(HttpServletRequest req) {
		try {
			List<Car> listCar = carService.listCar(getUserId(req));
			log.info("=====listCar.size={}======", listCar.size());

			return AjaxResultDTO.success(listCar);
		} catch (MALLException me) {
			log.error("查询购物车列表异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch(Exception e) {
			log.error("查询购物车列表异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("查询购物车列表失败");
		}
	}
	
	@RequestMapping("/addShopCar")
	@ResponseBody
	public AjaxResultDTO addShopCar( int goodsId, int goodsNum, ModelMap mm, HttpServletRequest req) {			

		try {
			log.info("=====goodsId={}, goodsNum={}======", goodsId, goodsNum);			
			carService.addCar(getUserId(req), goodsId, goodsNum);
			return AjaxResultDTO.success();					
		} catch (MALLException me) {
			log.error("添加购物车异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch(Exception e) {
			log.error("添加购物车异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("添加购物车失败");
		}
	}
	
	@RequestMapping("/deleteCar")
	@ResponseBody
	public AjaxResultDTO deleteCar(int carId) {
		try {
			log.info("=====carId={}======", carId);			
			carService.deleteCar(carId);
			return AjaxResultDTO.success();
		} catch (MALLException me) {
			log.error("删除购物车异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			log.error("删除购物车异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed(e.getMessage());
		}
	}
}
