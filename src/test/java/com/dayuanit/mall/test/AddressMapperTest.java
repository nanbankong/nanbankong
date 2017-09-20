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

import com.dayuanit.mall.daomain.Address;
import com.dayuanit.mall.mapper.AddressMapper;

@ContextConfiguration("/spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AddressMapperTest {

	@Autowired
	private AddressMapper addressMapper;
	
	private Address address;
	
	@Before
	public void init() {
		address = new Address();
		address.setUserId(1);
		address.setProvinceCode("1");
		address.setCityCode("1");
		address.setAreaCode("1");
		address.setProvinceName("1");
		address.setCityName("1");
		address.setAreaName("1");
		address.setDetailAddress("1");
		address.setPhone("1");
		address.setRealName("1");
		address.setStatus(1);
		address.setType(1);
		
	}
	
	@Test
	@Rollback
	public void testAddAddress() {
		int rows = addressMapper.addAddress(address);
		assertEquals(1, rows);
	}
	
	@Test
	@Rollback
	public void testGetAddressById() {
				
	}
	
	@Test
	@Rollback
	public void testListAddress() {
		addressMapper.addAddress(address);
		List<Address> listAddress = addressMapper.listAddress(address.getUserId());
		assertEquals(1, listAddress.size());
	}
	
	@Test
	@Rollback
	public void testUpdateAddressByStatus() {
		
		int rows = addressMapper.updateAddressByStatus(14);
		assertEquals(1, rows);
	}
	
	@Test
	@Rollback
	public void testUpdateAddressByType() {
		
		int rows = addressMapper.updateAddressByStatus(14);
		assertEquals(1, rows);
	}
}
