package com.dayuanit.mall.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AjaxResultDTO {

	private boolean success;
	private Object data;
	private String message;
	
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		
		String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(AjaxResultDTO.success());
		System.out.println(json);
	}

	private AjaxResultDTO() {

	}

	private AjaxResultDTO(boolean success, String message, Object data) {
		this.success = success;
		this.data = data;
		this.message = message;
	}

	public static AjaxResultDTO success(Object data) {
		return new AjaxResultDTO(true, null, data);
	}

	public static AjaxResultDTO success() {
		return new AjaxResultDTO(true, null, null);
	}

	public static AjaxResultDTO failed(String message) {
		return new AjaxResultDTO(false, message, null);
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
