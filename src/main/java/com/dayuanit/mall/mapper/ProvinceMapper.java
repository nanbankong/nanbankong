package com.dayuanit.mall.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProvinceMapper {

	List<Map<String, String>> listProvince();
	
	List<Map<String, String>> listCity(@Param("provinceCode") String provinceCode);
	
	List<Map<String, String>> listArea(@Param("cityCode") String cityCode);

    String getProvince(@Param("code") String code);
	
	String getCity(@Param("code") String code);
	
	String getArea(@Param("code") String code);
}
