package com.jusfoun.catalog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jusfoun.catalog.common.controller.BaseController;

/**
 * 业务目录
 * @author liudebin
 * 
 */
@Controller
public class BusinessContoller extends BaseController {

	/**
	 * 业务目录信息列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/business/index", method = RequestMethod.GET)
	public String getBusinessInfoList(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/business/businessIndex";
	}
	
	/**
	 * 业务目录维护
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/business/maintenance", method = RequestMethod.GET)
	public String getBusinessMaintenance(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/business/businessMaintenance";
	}
	
	/**
	 * 业务目录管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/business/manage", method = RequestMethod.GET)
	public String getBusinessManage(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/business/businessManage";
	}
	
	/**
	 * 业务目录编辑
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/business/edit", method = RequestMethod.GET)
	public String getBusinessEdit(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/business/businessEdit";
	}
}
