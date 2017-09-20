package com.dayuanit.mall.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayuanit.mall.mapper.ProvinceMapper;
import com.dayuanit.mall.service.ProvinceService;
import com.dayuanit.mall.service.RedisService;

@Service
public class ProvinceServiceImpl implements ProvinceService{

	private static final  Logger log = LoggerFactory.getLogger(ProvinceServiceImpl.class);

	@Autowired
	private ProvinceMapper provinceMapper;

	@Resource(name="redisTempServiceImpl")
	private RedisService redisService;
	
	@Override
	public List<Map<String, String>> listProvince() {
		String provinceKey = "mall:province";
		// 先到缓存里查询 如果存在 则返回 不存在则查询数据库
		boolean flag = redisService.haskey(provinceKey);
		if (flag) {
			log.info(">>>>省份走缓存");
			return redisService.getProvince(provinceKey);
		}
		List<Map<String, String>> provinceDate = provinceMapper.listProvince();
		
		redisService.setProvince(provinceKey, provinceDate);
		return provinceDate;
	}

	@Override
	public List<Map<String, String>> listCity(String provinceCode) {
		String cityKey = String.format("mall:city:%s", provinceCode);
		
		// 先到缓存里查询 如果存在 则返回 不存在则查询数据库
		boolean flag = redisService.haskey(cityKey);
		if (flag) {
			log.info(">>>>>城市走缓存，{}" + cityKey);
			return redisService.getCity(cityKey);
		}
		List<Map<String, String>> list = provinceMapper.listCity(provinceCode);
		redisService.setCity(cityKey, list);
		return list;
	}

	
	
	@Override
	public List<Map<String, String>> listArea(String cityCode) {
		String areaKey = String.format("mall:area:%s", cityCode);
		
		boolean flag = redisService.haskey(areaKey);
		if (flag) {
			log.info(">>>>>市区走缓存，{}" + areaKey);
			return redisService.getArea(areaKey);
		}
		List<Map<String, String>> list = provinceMapper.listArea(cityCode);
		redisService.setArea(areaKey, list);
		return list;
	}
	
	
}
