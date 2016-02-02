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

import com.alibaba.fastjson.JSONObject;
import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.common.tool.ServletTool;
import com.jusfoun.catalog.entity.Business;
import com.jusfoun.catalog.service.BusinessService;
import com.jusfoun.catalog.service.RegisterService;
import com.jusfoun.catalog.utils.LogUtils;
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
	 * 业务目录操作导航--针对create、update及view
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/business/action", method = RequestMethod.GET)
	public ModelAndView operBusinesAction(@RequestParam("type")String type,@RequestParam(value="id",required=false) Integer id){
		ModelAndView mav=new ModelAndView("admin/business/businessAction");
		if(null!=type&&!"".equals(type)&&(type.equals("view")||type.equals("update"))){
			if(id!=null){
				Business biz=businessService.get(id);
				if(biz!=null){
					mav.addObject("business", biz);
					if(type.equals("view")){
						mav.addObject("actionType", "view");
					}else{
						mav.addObject("actionType", "update");
					}
				}
			}			
		}else{
			mav.addObject("business", null);
			mav.addObject("actionType", "create");
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
		LogUtils.saveLog(ServletTool.getRequest(), "部门目录-业务信息维护-新建业务");
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
		LogUtils.saveLog(ServletTool.getRequest(), "部门目录-业务信息维护-编辑业务");
		return "redirect:"+adminPath+"/business/maintenance";
	}
	
	/**
	 * 批量更新业务
	 * @param biz
	 * @return
	 */	
	@RequestMapping(value = "${adminPath}/business/batchUpdateBiz", method = RequestMethod.POST)
	@ResponseBody
	public String batchUpdateBiz(@RequestParam(value="subId",required=false)Integer subId,@RequestParam(value="opType",required=false)Integer opType,@RequestParam(value="params")String params){
		businessService.batchUpdateBiz(subId,opType,params);		
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "${adminPath}/business/delBiz", method = RequestMethod.GET)
	public String delBiz(@RequestParam("id")Integer id){
		String delFlag="fail";
		if(null!=id){
			Business biz=new Business();
			biz.setId(id);
			businessService.delete(biz);
			LogUtils.saveLog(ServletTool.getRequest(), "部门目录-业务信息维护-删除业务");
			delFlag="success";
		}
		return delFlag;
	}
	
	@ResponseBody
	@RequestMapping(value = "${adminPath}/business/delBizLinkSub", method = RequestMethod.GET)
	public String delBizLinkSub(@RequestParam("id")Integer id){
		String delFlag="fail";
		if(null!=id){
			Business biz=new Business();
			biz.setId(id);
			biz.setSubjectId(0);
			businessService.updateBiz(biz);
			LogUtils.saveLog(ServletTool.getRequest(), "部门目录-业务信息维护-删除业务与主题间的关联");
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
	
    @RequestMapping(value = "${adminPath}/business/tree", method = RequestMethod.POST)
    @ResponseBody
	public Object tree(
			@RequestParam(name = "id", required = true) Integer officeId) {
		List<Business> business = businessService.findBusinessByOfficeId(officeId);
		if (business == null || business.size() == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Business bs : business) {
			// { id:1, pId:0, name:"父节点1", open:true,isParent:true},
			sb.append("{ id:" + bs.getId() + ", pId:"
					+ officeId + ", name:'" + bs.getName() +"',type:'business'},");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return JSONObject.parse(sb.toString());
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
		int start = (page-1)*rows+1;
		int end = page * rows;
		//把总记录和当前记录写到前台
		int total = businessService.findListCount(rsc);
		rsc.getSqlMap().put("start", ""+start);
		rsc.getSqlMap().put("end", ""+end);
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
			int start = (page-1)*rows+1;
			int end = page * rows;
			sqlMap.put("start", start);
			sqlMap.put("end", end);
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
			int start = (page-1)*rows+1;
			int end = page * rows;
			sqlMap.put("start", ""+start);
			sqlMap.put("end", ""+end);
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
