package com.dayuanit.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dayuanit.mall.daomain.User;
import com.dayuanit.mall.dto.AjaxResultDTO;
import com.dayuanit.mall.exception.MALLException;
import com.dayuanit.mall.service.UserService;
import com.dayuanit.mall.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/toRegist")
	public String toRegist() {
		return "regist";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}	
	
	@RequestMapping("/regist")
	@ResponseBody
	public AjaxResultDTO regist(@Validated UserVO userVO, HttpSession session, BindingResult br) {
		try {
			if (br.hasErrors()) {
				String msg = "";
				List<FieldError> errors = br.getFieldErrors();
				for (FieldError fd : errors) {
					msg += fd.getDefaultMessage() + ",";
				}
				return AjaxResultDTO.failed(msg);
			}
			
			String code = (String)session.getAttribute("code");
			if (!userVO.getCode().equals(code)) {
				session.removeAttribute("code");
				return AjaxResultDTO.failed("验证码错误");
			}			
			userService.regist(userVO.getUsername(), userVO.getPassword(), userVO.getPasswordOther(), userVO.getEmail());
		} catch (MALLException ae) {
			return AjaxResultDTO.failed(ae.getMessage());
		}
		return AjaxResultDTO.success();
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public AjaxResultDTO login(String username, String password, HttpServletRequest req) {
		try {
			User user = userService.login(username, password);
			req.getSession().setAttribute("login_user_flag", user);
		} catch (MALLException ae) {
			return AjaxResultDTO.failed(ae.getMessage());
		}
		return AjaxResultDTO.success();
	}
}
