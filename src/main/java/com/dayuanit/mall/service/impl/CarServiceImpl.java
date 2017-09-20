package com.dayuanit.mall.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayuanit.mall.daomain.Car;
import com.dayuanit.mall.daomain.Goods;
import com.dayuanit.mall.daomain.User;
import com.dayuanit.mall.exception.MALLException;
import com.dayuanit.mall.mapper.CarMapper;
import com.dayuanit.mall.mapper.GoodsMapper;
import com.dayuanit.mall.mapper.UserMapper;
import com.dayuanit.mall.service.CarService;

@Service
public class CarServiceImpl implements CarService{
	
	Logger log = LoggerFactory.getLogger(CarServiceImpl.class);

	@Autowired
	private CarMapper carMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addCar(int userId, int goodsId, int goodsNum) {
		
		User exitUser = userMapper.getUserById(userId);
		if (null == exitUser) {
			throw new MALLException("用户未登录");
		}
		
		Goods exitGoods = goodsMapper.getGoodsById(goodsId);
		if (null == exitGoods) {
			throw new MALLException("商品不存在");
		}
		Car car = new Car();
		car.setUserId(userId);
		car.setGoodsId(goodsId);
		car.setGoodsNum(goodsNum);
		car.setStatus(1);
		
		int rows = carMapper.addCar(car);
		

		if (1 != rows) {
			throw new MALLException("加入购失败");
		}		
	}

	@Override
	public List<Car> listCar(int userId) {
		User exitUser = userMapper.getUserById(userId);
		if (null == exitUser) {
			throw new MALLException("用户未登录");
		}
		return carMapper.listCar(userId);
	}

	@Override
	public Car queryCar(int goodsId) {
		return carMapper.getCarById(goodsId);
	}

	
//	User exitUser = userMapper.getUserById(userId);
//	
//	if (exitUser.getId().intValue() != userId) {
//		throw new MALLException("无权操作"); 
//	}
	
	@Override
	public void deleteCar(int carId) {
		Car exitCar = carMapper.getCarById(carId);
		if (null == exitCar) {
			throw new MALLException("商品不存在于购物车");
		}
		
		
		int rows = carMapper.updateStatus(carId, 2);
		if (1 != rows) {
			throw new MALLException("从购物车删除失败");
		}
	}

	@Override
	public List<Car> listCarByStatus(int userId, int status) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
