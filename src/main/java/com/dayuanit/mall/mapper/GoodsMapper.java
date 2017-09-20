package com.dayuanit.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dayuanit.mall.daomain.Goods;

public interface GoodsMapper {

	int addGoods(Goods goods);
	
	Goods getGoodsById(@Param("goodsId") Integer goodsId);
	
	List<Goods> getGoodsByCategoryId(@Param("categoryId") Integer categoryId);
}
