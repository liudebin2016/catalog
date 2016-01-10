package com.jusfoun.catalog.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.entity.Business;
import com.jusfoun.catalog.service.BusinessService;
import com.jusfoun.catalog.utils.UserUtils;

/**
 * 业务controller
 * @author liudebin
 * 
 */
@Controller
public class BusinessContoller extends BaseController {
	
	@Autowired
	private BusinessService businessService;

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
	 * 业务目录操作--针对create及update
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/business/action", method = RequestMethod.GET)
	public ModelAndView operBusinesAction(@RequestParam("type")String type,@RequestParam(value="id",required=false) Integer id){
		ModelAndView mav=new ModelAndView("admin/business/businessAction");
		if(null!=type&&!"".equals(type)&&type.equals("update")){
			if(id!=null){
				Business biz=businessService.get(id);
				if(biz!=null){
					mav.addObject("business", biz);
				}
			}			
		}else{
			mav.addObject("business", null);
		}
		return mav;
	}
	
	/**
	 * 新建业务
	 * @param biz
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/business/createBiz", method = RequestMethod.POST)
	public String createBiz(Business biz){
		biz.setCreateBy(UserUtils.getUser());
		biz.setCreateDate(new Date());
		businessService.save(biz);
		return "redirect:"+adminPath+"/business/maintenance";
	}
	
	/**
	 * 更新业务
	 * @param biz
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/business/updateBiz", method = RequestMethod.POST)
	public String updateBiz(Business biz){
		
		return "";
	}
	
	
}
