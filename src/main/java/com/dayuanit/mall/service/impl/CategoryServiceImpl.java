package com.dayuanit.mall.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayuanit.mall.controller.CarController;
import com.dayuanit.mall.daomain.Category;
import com.dayuanit.mall.mapper.CategoryMapper;
import com.dayuanit.mall.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> queryCategory() {
		
		List<Category> listCategory = categoryMapper.getCategoryByStatus();
		return listCategory;
	}
}
