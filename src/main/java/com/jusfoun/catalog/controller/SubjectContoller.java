package com.jusfoun.catalog.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.entity.SubjectInfo;
import com.jusfoun.catalog.service.SubjectService;
import com.jusfoun.catalog.utils.UserUtils;
import com.jusfoun.catalog.vo.CatalogTree;

/**
 * 主题目录
 * @author liudebin
 * 
 */
@Controller
public class SubjectContoller extends BaseController {
	
	@Autowired
	private SubjectService subjectService;

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
	 * 主题目录操作控制（创建还是修改？）
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/action", method = RequestMethod.GET)
	public ModelAndView action(@RequestParam("type") String type,@RequestParam(value="subjectId",required=false) Integer subjectId){
		ModelAndView mav = new ModelAndView("admin/subject/subjectCreate");
		if(null!=type&&!"".equals(type)&&type.equals("update")){
			if(subjectId!=null){
				SubjectInfo si=subjectService.get(subjectId);
				if(si!=null){
					mav.addObject("subject", si);
				}
			}
		}else{
			mav.addObject("subject", null);
		}
		
		return mav;
	}
	
	/**
	 * 主题目录创建
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/doCreate", method = RequestMethod.POST)
	public String getSubjectDoCreate(HttpServletRequest request, HttpServletResponse response,Model model){
		String name=request.getParameter("name");
		String descr=request.getParameter("descr");
		String shareRegion=request.getParameter("shareRegion");
		String shareMode=request.getParameter("shareMode");
		String status=request.getParameter("status");
		SubjectInfo si=new SubjectInfo();
		si.setName(name);
		si.setDescr(descr);
		si.setShareMode(shareMode);
		si.setShareRegion(shareRegion);
		si.setStatus(Integer.valueOf(status));
		si.setCreateBy(UserUtils.getUser());
		si.setCreateDate(new Date());
		subjectService.saveSubjectInfo(si);
		
		return "admin/subject/subjectManage";
	}
	
	/**
	 * 主题目录更新
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/doUpdate", method = RequestMethod.POST)
	public String getSubjectDoUpdate(HttpServletRequest request, HttpServletResponse response){
		String name=request.getParameter("name");
		String descr=request.getParameter("descr");
		String shareRegion=request.getParameter("shareRegion");
		String shareMode=request.getParameter("shareMode");
		String status=request.getParameter("status");
		SubjectInfo si=new SubjectInfo();
		si.setName(name);
		si.setDescr(descr);
		si.setShareMode(shareMode);
		si.setShareRegion(shareRegion);
		si.setStatus(Integer.valueOf(status));
		si.setCreateBy(UserUtils.getUser());
		si.setCreateDate(new Date());
		subjectService.update(si);
		
		return "admin/subject/subjectManage";
	}
	
	/**
	 * 主题删除
	 * @param subjectId
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/del", method = RequestMethod.POST)
	public String getSubjectDel(@RequestParam(value="subjectId")Integer subjectId ){
		SubjectInfo si=new SubjectInfo();
		si.setId(subjectId);
		subjectService.delete(si);
		
		return "admin/subject/subjectManage";
	}
	
	/**
	 * 主题目录管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/manage", method = RequestMethod.GET)
	public String getSubjectManage(){
		return "admin/subject/subjectManage";
	}
	
	@RequestMapping(value = "${adminPath}/subject/tree", method = RequestMethod.POST)
	@ResponseBody
	public Object tree(){
		List<CatalogTree> ctList=subjectService.getSubjectCatalogTree(null);
		return JsonMapper.toJsonString(ctList);
	}
	
	/**
	 * 主题信息关联
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/link", method = RequestMethod.GET)
	public String getSubjectLink(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/subject/subjectLink";
	}
}