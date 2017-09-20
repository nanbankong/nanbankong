package com.dayuanit.mall.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dayuanit.mall.daomain.Category;
import com.dayuanit.mall.mapper.CategoryMapper;

@ContextConfiguration("/spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CategoryMapperTest {

	@Autowired
	private CategoryMapper categoryMapper;
	
	private Category category;
	
	@Before
	public void init() {
		category = new Category();
		category.setCategoryName("1");
		category.setStatus(1);
	}
	
	@Test
	@Rollback
	public void testAddCategory() {
		int rows = categoryMapper.addCategory(category);
		assertEquals(1, rows);
		
	}
	
	@Test
	@Rollback
	public void testGetCategoryByStatus() {
		List<Category> list = categoryMapper.getCategoryByStatus();
		assertEquals(2, list.size());
	}
}
