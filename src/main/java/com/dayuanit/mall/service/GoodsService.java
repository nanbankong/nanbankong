package com.dayuanit.mall.service;

import java.util.List;

import com.dayuanit.mall.daomain.Goods;

public interface GoodsService {

	Goods getGoodsById(int goodsId);
	
	List<Goods> getGoodsByCategoryId(int categoryId);
}
