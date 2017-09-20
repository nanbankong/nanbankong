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
import com.dayuanit.mall.daomain.Car;
import com.dayuanit.mall.mapper.CarMapper;

@ContextConfiguration("/spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CarMapperTest {
	
	@Autowired
	private CarMapper carMapper;
	
	private Car car;
	
	@Before
	public void init() {
		car = new Car();
		car.setUserId(1);
		car.setGoodsId(1);
		car.setGoodsNum(10);
		car.setStatus(1);			
	}
	
	@Test
	@Rollback
	public void testAddCar() {
		int rows = carMapper.addCar(car);
		assertEquals(1, rows);
	}
	
	@Test
	@Rollback
	public void testGetCarById() {
		carMapper.addCar(car);
		Car queryCar = carMapper.getCarById(car.getId());
		assertEquals(queryCar.getId(), car.getId());
	}
	
	@Test
	@Rollback
	public void testListCar() {
		carMapper.addCar(car);
		List<Car> listCar = carMapper.listCar(car.getUserId());
		assertEquals(1, listCar.size());
	}
	
	@Test
	@Rollback
	public void testDeleteCar() {
		carMapper.addCar(car);
		int rows = carMapper.deleteCar(car.getGoodsId());
		assertEquals(1,rows);
	}
	
	@Test
	@Rollback
	public void testUpdateStatus() {
		carMapper.addCar(car);
		int rows = carMapper.updateStatus(car.getId(), 2);
		assertEquals(1, rows);
	}
	
}
