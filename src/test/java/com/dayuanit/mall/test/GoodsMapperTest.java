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

import com.dayuanit.mall.daomain.Goods;
import com.dayuanit.mall.mapper.GoodsMapper;

@ContextConfiguration("/spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class GoodsMapperTest {

	@Autowired
	private GoodsMapper goodsMapper;
	
	private Goods goods;
	
	@Before
	public void init() {
		goods = new Goods();
		goods.setGoodsName("1");
		goods.setPrice(10.0);
		goods.setNumber(300);
		goods.setTips("好");
		goods.setStatus(1);
		goods.setCategoryId(1);
		goods.setSoldNumber(39);
		goods.setPicture("001");		
	}
	
	@Test
	@Rollback
	public void testAddGoods() {
		int rows = goodsMapper.addGoods(goods);
		assertEquals(1, rows);
	}
	
	@Test
	public void testGetGoodsById() {
		goodsMapper.addGoods(goods);
		Goods queryGoods = goodsMapper.getGoodsById(goods.getId());
		assertEquals(queryGoods.getId(),goods.getId());
	}
	
	@Test
	public void getGoodsByCategoryId() {
		List<Goods> list = goodsMapper.getGoodsByCategoryId(1);
		assertEquals(8, list.size());
	}
}
