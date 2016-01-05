package com.jusfoun.catalog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jusfoun.catalog.common.controller.BaseController;

/**
 * 主题目录
 * @author liudebin
 * 
 */
@Controller
public class SubjectContoller extends BaseController {

	/**
	 * 主题目录信息列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/index", method = RequestMethod.GET)
	public String getSubjectInfoList(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/subject/subjectIndex";
	}
	
	/**
	 * 主题目录维护
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/create", method = RequestMethod.GET)
	public String getSubjectCreate(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/subject/subjectCreate";
	}
	
	/**
	 * 主题目录管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/manage", method = RequestMethod.GET)
	public String getSubjectManage(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/subject/subjectManage";
	}
	
	/**
	 * 主题目录编辑
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/link", method = RequestMethod.GET)
	public String getSubjectLink(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/subject/subjectLink";
	}
}
