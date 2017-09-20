package com.dayuanit.mall.service;

import java.util.List;
import com.dayuanit.mall.daomain.Car;

public interface CarService {

	void addCar(int userId, int goodsId, int goodsNum);
	
	List<Car> listCar(int userId);
	
	Car queryCar(int carId);
	
	void deleteCar(int carId);
	
	List<Car> listCarByStatus(int userId, int status);
}
