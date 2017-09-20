package com.dayuanit.mall.service;

import java.util.List;

import com.dayuanit.mall.daomain.Address;
import com.dayuanit.mall.dto.AddressDTO;
import com.dayuanit.mall.vo.AddressVO;

public interface AddressService {

	void addAddress(AddressVO vo, int userId);
	
	Address getAddressById(int addressId);
	
	List<AddressDTO> listAddress(int userId);
	
	void updateAddressByStatus(int addressId, int userId);
	
	void updateAddressByType(int addressId);
	
	void modify(AddressVO vo, int userId);
}
