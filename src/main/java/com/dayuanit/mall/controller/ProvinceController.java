package com.dayuanit.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dayuanit.mall.dto.AjaxResultDTO;
import com.dayuanit.mall.service.ProvinceService;

@Controller
@RequestMapping("/province")
public class ProvinceController extends BaseController{

	Logger log = LoggerFactory.getLogger(ProvinceController.class);

	@Autowired
	private ProvinceService provinceService;
	
	@RequestMapping("/listProvince")
	@ResponseBody
	public AjaxResultDTO listProvince() {
		return AjaxResultDTO.success(provinceService.listProvince());
	}
	
	@RequestMapping("/listCity")
	@ResponseBody
	public AjaxResultDTO listCity(String provinceCode) {
		log.info("=====provinceCode={}======", provinceCode);

		return AjaxResultDTO.success(provinceService.listCity(provinceCode));
	}
	
	@RequestMapping("/listArea")
	@ResponseBody
	public AjaxResultDTO listArea(String cityCode) {
		log.info("=====cityCode={}======", cityCode);

		return AjaxResultDTO.success(provinceService.listArea(cityCode));
	}
}
