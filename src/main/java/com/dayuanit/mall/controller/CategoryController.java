package com.dayuanit.mall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dayuanit.mall.daomain.Category;
import com.dayuanit.mall.dto.AjaxResultDTO;
import com.dayuanit.mall.exception.MALLException;
import com.dayuanit.mall.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController{

	Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/listCategory")
	@ResponseBody
	public AjaxResultDTO listCategory() {
		
		try {
			List<Category> listCategory = categoryService.queryCategory();			
			ObjectMapper om = new ObjectMapper();
			String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(AjaxResultDTO.success(listCategory));
			System.out.println(json);
			return AjaxResultDTO.success(listCategory);
		} catch (MALLException me) {
			log.error("查询目录列表异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch (Exception e) {
			log.error("查询目录列表异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed(e.getMessage());
		} 		
	}
}
