package com.jusfoun.catalog.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.mapper.JsonMapper;
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
	public String getBusinessInfoList(){
		
		return "admin/business/businessIndex";
	}
	
	/**
	 * 业务目录维护
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/business/maintenance")
	public String getBusinessMaintenance(){
		return "admin/business/businessMaintenance";
	}
	
	/**
	 * 业务目录管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/business/manage", method = RequestMethod.GET)
	public String getBusinessManage(){
		
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
		businessService.updateBiz(biz);		
		return "redirect:"+adminPath+"/business/maintenance";
	}
	
	@ResponseBody
	@RequestMapping(value = "${adminPath}/business/delBiz", method = RequestMethod.GET)
	public String delBiz(@RequestParam("id")Integer id){
		String delFlag="fail";
		if(null!=id){
			Business biz=new Business();
			biz.setId(id);
			businessService.delete(biz);
			delFlag="success";
		}
		return delFlag;
	}
	
	@RequestMapping(value = "${adminPath}/business/businessTree", method = RequestMethod.POST)
    @ResponseBody
	public Object businessTree(
			@RequestParam(name = "officeId", required = true) Integer officeId) {
		List<Business> business = businessService.findBusinessByOfficeId(officeId);
		if (business != null && business.size() > 0) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("business", business);
			return result;
		} else {
			return Collections.EMPTY_LIST;
		}
	}
	
	@RequestMapping(value = "${adminPath}/business/businessInfo", method = RequestMethod.POST)
	@ResponseBody
	public Object businessInfo(@RequestParam(value="id",required=true) Integer id){
			Business bs = businessService.get(id);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("succ", 1);
			result.put("bs", bs);
			return result;
	}
	
	/**
	 * 业务列表,根据当前页和记录数获取列表
	 * @param page 当前页
	 * @param rows 页面记录数
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("${adminPath}/business/bizList")
	public  String bizList(int page,int rows,HttpServletRequest request) throws IOException{
		String name=WebUtils.getCleanParam(request,"name");
		String status=WebUtils.getCleanParam(request,"status");
		String id=WebUtils.getCleanParam(request,"id");
		Business rsc=new Business();
		if(null!=name||null!=status){
			if(null!=name){
				rsc.setName("%"+name+"%");
			}
			rsc.setStatus(status);
		}
		if(null!=id){
			rsc.setId(Integer.valueOf(id));
		}
		//求得开始记录与结束记录
		int start = (page-1)*rows;
		int end = page * rows;
		//把总记录和当前记录写到前台
		int total = businessService.findListCount(rsc);
		rsc.getSqlMap().put("page", "limit "+start+","+end);
		List<Business> uList = businessService.findList(rsc);
		String json = JsonMapper.toJsonString(uList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
		return sb.toString();
	}
	
	@ResponseBody
	@RequestMapping("${adminPath}/business/findBySubId")
	public  String findListBySubjectId(int page,int rows,HttpServletRequest request) throws IOException{
		String subjectId=WebUtils.getCleanParam(request,"subjectId");
		StringBuffer sb=new StringBuffer();
		if(null!=subjectId){
			//把总记录和当前记录写到前台
			Map<String,Object> sqlMap=new HashMap<String,Object>();
			//求得开始记录与结束记录
			int start = (page-1)*rows;
			int end = page * rows;
			sqlMap.put("page", "limit "+start+","+end);
			sqlMap.put("subjectId", Integer.valueOf(subjectId));
			int total = businessService.findListCountBySubId(sqlMap);
			List<Business> bList = businessService.findListBySubId(sqlMap);
			String json = JsonMapper.toJsonString(bList);
			sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
			return sb.toString();
		}
		return "{\"total\":0,\"rows\":[]}";
	}
	
	@ResponseBody
	@RequestMapping("${adminPath}/business/findByRscId")
	public  String findListByRscId(int page,int rows,HttpServletRequest request) throws IOException{
		String resourceId=WebUtils.getCleanParam(request,"resourceId");
		StringBuffer sb=new StringBuffer();
		if(null!=resourceId){
			//把总记录和当前记录写到前台
			Map<String,Object> sqlMap=new HashMap<String,Object>();
			//求得开始记录与结束记录
			int start = (page-1)*rows;
			int end = page * rows;
			sqlMap.put("page", "limit "+start+","+end);
			sqlMap.put("resourceId", Integer.valueOf(resourceId));
			int total = businessService.findListCountByRscId(sqlMap);
			List<Business> bList = businessService.findListByRscId(sqlMap);
			String json = JsonMapper.toJsonString(bList);
			sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
			return sb.toString();
		}
		return "{\"total\":0,\"rows\":[]}";
	}
}
