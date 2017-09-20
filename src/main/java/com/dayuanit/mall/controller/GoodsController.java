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

import com.dayuanit.mall.daomain.Goods;
import com.dayuanit.mall.dto.AjaxResultDTO;
import com.dayuanit.mall.exception.MALLException;
import com.dayuanit.mall.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController{
	
	@Autowired
	private GoodsService goodsService;

	Logger log = LoggerFactory.getLogger(GoodsController.class);

	@RequestMapping("/listGoods")
	@ResponseBody
	public AjaxResultDTO listGoods(int categoryId) {
		
		try {
			log.info("=====categoryId={}======", categoryId);

			List<Goods> listGoods = goodsService.getGoodsByCategoryId(categoryId);
			return AjaxResultDTO.success(listGoods);		
		} catch(MALLException ae) {
			log.error("查询目录列表异常,{}", ae.getMessage(), ae);
			return AjaxResultDTO.failed(ae.getMessage());
		} catch (Exception e) {
			log.error("查询目录列表异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed(e.getMessage());
		} 
	}

	@RequestMapping("/toGetGoods")
	public String toGetGoods(int goodsId,  ModelMap mm) {
		log.info("=====goodsId={}======", goodsId);

		Goods goods = goodsService.getGoodsById(goodsId);
		log.info("=====goodsId={}, goodsName={}======", goods.getId(), goods.getGoodsName());
		mm.addAttribute("goods", goods);
		return "goods";
	}
	
	@RequestMapping("/getGoods")
	@ResponseBody
	public AjaxResultDTO getGoods(int goodsId, HttpServletRequest req) {
		try {
			log.info("=====goodsId={}======", goodsId);

			Goods goods = goodsService.getGoodsById(goodsId);
			log.info("=====goodsId={}, goodsName={}======", goods.getId(), goods.getGoodsName());

			req.setAttribute("goods", goods);
			return AjaxResultDTO.success(goods);			
		} catch (MALLException me) {
			log.error("查询商品异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			log.error("查询商品异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed(e.getMessage());
		} 
	}
}
