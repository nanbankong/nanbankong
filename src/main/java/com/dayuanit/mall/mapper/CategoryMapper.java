package com.dayuanit.mall.mapper;

import java.util.List;

import com.dayuanit.mall.daomain.Category;

public interface CategoryMapper {
	
	int addCategory(Category category);
	
	List<Category> getCategoryByStatus();
}
