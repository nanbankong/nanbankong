package com.dayuanit.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dayuanit.mall.daomain.Address;

public interface AddressMapper {

	int addAddress(Address address);
	
	Address getAddressById(@Param("addressId") Integer addressId);
	
	List<Address> listAddress(@Param("userId") Integer userId);
	
	int modifyAddress(Address address);
	
	int updateAddressByStatus(@Param("addressId") Integer addressId);
	
	int updateAddressByType(@Param("addressId") Integer addressId);
}
