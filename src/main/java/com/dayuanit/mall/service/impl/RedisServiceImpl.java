package com.dayuanit.mall.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dayuanit.mall.data.redis.RedisUtils;
import com.dayuanit.mall.service.RedisService;

import redis.clients.jedis.Jedis;

@Service
public class RedisServiceImpl implements RedisService{

	private static final Logger log = LoggerFactory.getLogger(RedisServiceImpl.class);

	@Override
	public boolean haskey(String key) {
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getRedis();
			return jedis.exists(key);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		
	}

	@Override
	public List<Map<String, String>> getProvince(String key) {
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getRedis();
			List list = JSON.parseArray(jedis.get(key), Map.class);
			return list;
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}		
	}

	@Override
	public void setProvince(String key, List<Map<String, String>> value) {
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getRedis();
			String valueStr = JSON.toJSONString(value);
			log.info(">>>>>保存省份内容：{}", valueStr);
			jedis.set(key, valueStr);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}

	@Override
	public List<Map<String, String>> getCity(String key) {
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getRedis();
			List list = JSON.parseArray(jedis.get(key), Map.class);
			return list;
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}

	@Override
	public void setCity(String key, List<Map<String, String>> value) {
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getRedis();
			String valueStr = JSON.toJSONString(value);
			log.info(">>>>>保存市内容：{}", valueStr);
			jedis.set(key, valueStr);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}

	@Override
	public List<Map<String, String>> getArea(String key) {
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getRedis();
			List list = JSON.parseArray(jedis.get(key), Map.class);
			return list;
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
		
	}

	@Override
	public void setArea(String key, List<Map<String, String>> value) {
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getRedis();
			String valueStr = JSON.toJSONString(value);
			log.info(">>>>>保存市内容：{}", valueStr);
			jedis.set(key, valueStr);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}
}
