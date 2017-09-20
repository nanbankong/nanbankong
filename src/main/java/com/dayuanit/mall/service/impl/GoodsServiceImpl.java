package com.dayuanit.mall.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dayuanit.mall.daomain.Goods;
import com.dayuanit.mall.exception.MALLException;
import com.dayuanit.mall.mapper.GoodsMapper;
import com.dayuanit.mall.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public Goods getGoodsById(int goodsId) {
		
		Goods goods = goodsMapper.getGoodsById(goodsId);
		if (null == goods) {
			throw new MALLException("商品不存在");
		}
		return goods;
	}

	@Override
	public List<Goods> getGoodsByCategoryId(int categoryId) {
		
		List<Goods> listGoods = goodsMapper.getGoodsByCategoryId(categoryId);
		return listGoods;
	}

}
