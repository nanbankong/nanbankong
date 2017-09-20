package com.dayuanit.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dayuanit.mall.dto.AddressDTO;
import com.dayuanit.mall.dto.AjaxResultDTO;
import com.dayuanit.mall.exception.MALLException;
import com.dayuanit.mall.service.AddressService;
import com.dayuanit.mall.vo.AddressVO;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
	
	Logger log = LoggerFactory.getLogger(AddressController.class);

	@Autowired
	private AddressService addressService;

	@RequestMapping("/toAddress")
	public String toAddressr(Model  model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("address");
		return "address2";
	}
	
	@RequestMapping("/addAddress")
	@ResponseBody
	public AjaxResultDTO addAddress(AddressVO vo, HttpServletRequest req) {
		 try {
			 
				log.info("=====vo.addressId={}======", vo.getAddressId());

			 addressService.addAddress(vo, getUserId(req));
			 return AjaxResultDTO.success();
		 } catch (MALLException me) {
			 log.error("添加收获地址异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		 } catch(Exception e) {
			log.error("添加收获地址异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("添加收获地址异常，请联系客服");
		 }
	}
	
	@RequestMapping("/listAddress")
	@ResponseBody
	public AjaxResultDTO listAddress(HttpServletRequest req) {
		
		try {
			List<AddressDTO> dto =addressService.listAddress(getUserId(req)); 
			return AjaxResultDTO.success(dto);
		} catch (MALLException me) {
			log.error("查询收获地址异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch(Exception e) {
			log.error("查询收获地址异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("查询收获地址失败");
		}
	}
	
	@RequestMapping("/modify")
	@ResponseBody
	public AjaxResultDTO modify(AddressVO vo, HttpServletRequest req) {
		
		try {
			log.info("=====vo.addressId={}======", vo.getAddressId());

			addressService.modify(vo, getUserId(req));
			return AjaxResultDTO.success();
		} catch(MALLException me) {
			log.error("修改收货地址异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch(Exception e) {
			log.error("修改收货地址异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("修改收货地址失败");
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResultDTO delete(int addressId, HttpServletRequest req) {
		
		try {
			log.info("=====addressId={}======", addressId);
			addressService.updateAddressByStatus(addressId, getUserId(req));
			return AjaxResultDTO.success();
		} catch(MALLException me) {
			log.error("删除收货地址异常,{}", me.getMessage(), me);
			return AjaxResultDTO.failed(me.getMessage());
		} catch(Exception e) {
			log.error("删除收货地址异常,{}", e.getMessage(), e);
			return AjaxResultDTO.failed("删除收货地址失败");
		}
	}
}
