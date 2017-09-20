package com.dayuanit.mall.data.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {

	private static final JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.8.105");
	
	private static final Logger log = LoggerFactory.getLogger(RedisUtils.class);

	public static Jedis getRedis() {
		return pool.getResource();
	}
	
	public static void setValue(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(key, value);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}
	
	public static String getValue(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			return jedis.get(key);
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}
	
	public static void main(String[] args) {
		RedisUtils.setValue("mall:good", "你好jedis");
		String msg = RedisUtils.getValue("mall:good");
		log.info(msg);
	}
}
