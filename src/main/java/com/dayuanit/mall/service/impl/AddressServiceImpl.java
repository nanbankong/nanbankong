package com.dayuanit.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayuanit.mall.daomain.Address;
import com.dayuanit.mall.daomain.User;
import com.dayuanit.mall.dto.AddressDTO;
import com.dayuanit.mall.exception.MALLException;
import com.dayuanit.mall.mapper.AddressMapper;
import com.dayuanit.mall.mapper.ProvinceMapper;
import com.dayuanit.mall.mapper.UserMapper;
import com.dayuanit.mall.service.AddressService;
import com.dayuanit.mall.vo.AddressVO;

@Service
public class AddressServiceImpl implements AddressService{

	Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ProvinceMapper provinceMapper;
	
	@Override
	public void addAddress(AddressVO vo, int userId) {
		Address address = new Address();
		address.setUserId(userId);
		address.setProvinceCode(vo.getProvinceCode());
		
		String provinceName = provinceMapper.getProvince(vo.getProvinceCode());
		address.setProvinceName(provinceName);
		
		address.setCityCode(vo.getCityCode());
		String cityName = provinceMapper.getCity(vo.getCityCode());
		address.setCityName(cityName);
		
		address.setAreaCode(vo.getAreaCode());
		String areaName = provinceMapper.getArea(vo.getAreaCode());
		address.setAreaName(areaName);
		
		address.setDetailAddress(vo.getDetailAddress());
		address.setPhone(vo.getPhone());
		address.setRealName(vo.getRealName());
		address.setType(vo.getType());
		address.setStatus(1);
		
		int rows = addressMapper.addAddress(address);
		if (1 != rows) {
			throw new MALLException("添加地址失败");
		}
	}

	@Override
	public Address getAddressById(int addressId) {
		
		return addressMapper.getAddressById(addressId);
	}

	@Override
	public List<AddressDTO> listAddress(int userId) {
		User exitUser = userMapper.getUserById(userId);
		if (null == exitUser) {
			throw new MALLException("用户未登录");
		}
		
		List<Address> address = addressMapper.listAddress(userId);
		List<AddressDTO> dtos = new ArrayList<AddressDTO>(address.size());
		for (Address add : address) {
			AddressDTO dto = new AddressDTO();
			dtos.add(dto);
			
			dto.setArea(add.getAreaName());
			dto.setAreaCode(add.getAreaCode());
			dto.setCity(add.getCityName());
			dto.setCityCode(add.getCityCode());
			dto.setProvince(add.getProvinceName());
			dto.setProvinceCode(add.getProvinceCode());
			dto.setDetail(add.getDetailAddress());
			dto.setId(add.getId());
			dto.setPhone(add.getPhone());
			dto.setIsDef(add.getType());
			dto.setUserRealName(add.getRealName());
			
		}
		return dtos;
	}

	@Override
	public void updateAddressByStatus(int addressId, int userId) {
		log.info("=====addressId={}======", addressId);

		Address exitAddress = addressMapper.getAddressById(addressId);
		if (null == exitAddress) {
			throw new MALLException("没有此地址"); 
		}
		
		User exitUser = userMapper.getUserById(userId);
		
		if (exitUser.getId().intValue() != userId) {
			throw new MALLException("无权操作"); 
		}
		
		int rows = addressMapper.updateAddressByStatus(addressId);
		if (1 != rows) {
			throw new MALLException("修改地址状态失败");
		}
	}

	@Override
	public void updateAddressByType(int addressId) {
		
		Address exitAddress = addressMapper.getAddressById(addressId);
		if (null != exitAddress) {
			throw new MALLException("没有此地址"); 
		}
		
		int rows = addressMapper.updateAddressByType(addressId);
		if (1 != rows) {
			throw new MALLException("设为默认地址失败");
		}
	}

	@Override
	public void modify(AddressVO vo, int userId) {
		
		User exitUser = userMapper.getUserById(userId);
		if (null == exitUser) {
			throw new MALLException("用户未登录");
		}
		
		Address address = new Address();
		address.setUserId(userId);
		address.setProvinceCode(vo.getProvinceCode());
		
		String provinceName = provinceMapper.getProvince(vo.getProvinceCode());
		address.setProvinceName(provinceName);
		
		address.setCityCode(vo.getCityCode());
		String cityName = provinceMapper.getCity(vo.getCityCode());
		address.setCityName(cityName);
		
		address.setAreaCode(vo.getAreaCode());
		String areaName = provinceMapper.getArea(vo.getAreaCode());
		address.setAreaName(areaName);
		
		address.setDetailAddress(vo.getDetailAddress());
		address.setPhone(vo.getPhone());
		address.setRealName(vo.getRealName());
		address.setType(vo.getType());
		address.setStatus(1);
		address.setId(vo.getAddressId());
		
		log.info("=====vo.addressId={}======", vo.getAddressId());

		int rows = addressMapper.modifyAddress(address);
		if (1 != rows) {
			throw new MALLException("修改地址失败");
		}
	}
	
	
}
