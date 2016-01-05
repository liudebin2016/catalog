package com.jusfoun.catalog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jusfoun.catalog.common.controller.BaseController;

/**
 * 注册申请、注册审批
 * @author liudebin
 * 
 */
@Controller
public class RegisterContoller extends BaseController {

	/**
	 * 注册申请
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/register/info", method = RequestMethod.GET)
	public String getRegisterInfoList(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/register/registerInfo";
	}
	
	/**
	 * 注册申请
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/register/approve", method = RequestMethod.GET)
	public String getRegisterApprove(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/register/registerApprove";
	}
	
}
