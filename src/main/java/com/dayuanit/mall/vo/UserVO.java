package com.dayuanit.mall.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UserVO {

	@NotNull
	@Length(min=5, max=10, message="用户名长度有问题")
	private String username;
	
	@NotNull
	@Length(min=1, max=10, message="密码长度有问题")
	private String password;
	private String passwordOther;
	
	@NotNull
	@Email(message="邮箱格式不正确")
	private String email;
	private String code;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordOther() {
		return passwordOther;
	}
	public void setPasswordOther(String passwordOther) {
		this.passwordOther = passwordOther;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
