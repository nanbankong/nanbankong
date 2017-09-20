package com.dayuanit.mall.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.dayuanit.mall.daomain.Car;

public interface CarMapper {

	int addCar(Car car);
	
	Car getCarById(@Param("carId") Integer carId);
	
	List<Car> listCar(@Param("userId") Integer userId);
	
	int deleteCar(@Param("goodsId") Integer goodsId);
	
	int updateStatus(@Param("carId") Integer carId, @Param("status") Integer status);
}
