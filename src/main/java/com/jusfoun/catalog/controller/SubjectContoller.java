package com.jusfoun.catalog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.dao.SubjectInfoDao;

/**
 * 主题目录
 * @author liudebin
 * 
 */
@Controller
public class SubjectContoller extends BaseController {
	
	@Autowired
	private SubjectInfoDao sessionDAO;

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
	 * 主题目录维护
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/doCreate", method = RequestMethod.POST)
	public String getSubjectDoCreate(HttpServletRequest request, HttpServletResponse response){
		String name=request.getParameter("name");
		String descr=request.getParameter("descr");
		String shareRegion=request.getParameter("shareRegion");
		String shareMode=request.getParameter("shareMode");
		String status=request.getParameter("status");
		
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
