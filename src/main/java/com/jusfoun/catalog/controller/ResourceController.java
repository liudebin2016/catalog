package com.jusfoun.catalog.controller;

import java.io.IOException;
import java.util.Collections;
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
import com.jusfoun.catalog.entity.ResourceInfo;
import com.jusfoun.catalog.service.ResourceService;

/**
 * 资源Controller
 * @author admin
 *
 */
@Controller
public class ResourceController extends BaseController {
	
	@Autowired
	private ResourceService resourceService;
    
	/**
	 * 资源目录管理
	 * @return
	 */
    @RequestMapping(value = "${adminPath}/resource/manage", method = RequestMethod.GET)
    public String manage(){
    	return "admin/resource/manage";
    }
    
    @RequestMapping(value = "${adminPath}/resource/resourceTree", method = RequestMethod.POST)
    @ResponseBody
	public Object resourceTree(
			@RequestParam(name = "officeId", required = true) Integer officeId) {
		List<ResourceInfo> resource = resourceService.findResourceByOfficeId(officeId);
		if (resource != null && resource.size() > 0) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("resource", resource);
			return result;
		} else {
			return Collections.EMPTY_LIST;
		}
	}
	
	@RequestMapping(value = "${adminPath}/resource/resourceInfo", method = RequestMethod.POST)
	@ResponseBody
	public Object resourceInfo(@RequestParam(value="id",required=true) Integer id){
			ResourceInfo rs = resourceService.get(id);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("succ", 1);
			result.put("rs", rs);
			return result;
	}
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "${adminPath}/resource/index", method = RequestMethod.GET)
    public String index() {
    	return "admin/resource/index";
    }
    
    /**
     * 操作导航
     * @param type
     * @param id
     * @return
     */
    @RequestMapping(value = "${adminPath}/resource/action", method = RequestMethod.GET)
    public ModelAndView action(@RequestParam("type")String type,@RequestParam(value="id",required=false) Integer id) {
    	ModelAndView mav=new ModelAndView("admin/resource/action");
    	if(null!=type&&!"".equals(type)&&(type.equals("update")||type.equals("view"))){
    		if(null!=id){
    			ResourceInfo rscInfo=resourceService.get(id);
    			if(null!=rscInfo){
    				mav.addObject("rsc", rscInfo);
    				if(type.equals("view")){
						mav.addObject("actionType", "view");
					}else{
						mav.addObject("actionType", "update");
					}
    			}
    		}
    	}else{
    		mav.addObject("rsc", null);
    		mav.addObject("actionType", "create");
    	}
    	return mav;
    }
    
    /**
     * 创建资源
     * @param rsc
     * @return
     */
    @RequestMapping(value = "${adminPath}/resource/createRsc", method = RequestMethod.POST)
    public String createRsc(ResourceInfo rsc) {
    	resourceService.save(rsc);
    	return "redirect:"+adminPath+"/resource/maintenance";
    }
    
    /**
     * 更新资源
     * @param rsc
     * @return
     */
    @RequestMapping(value = "${adminPath}/resource/updateRsc", method = RequestMethod.POST)
    public String updateRsc(ResourceInfo rsc) {
    	resourceService.updateRsc(rsc);
    	return "redirect:"+adminPath+"/resource/maintenance";
    }
    
    /**
     * 维护资源
     * @param request
     * @return
     */
    @RequestMapping(value = "${adminPath}/resource/maintenance")
    public String maintenance(){    	
    	return "admin/resource/maintenance";
    }
    
    /**
     * 删除资源
     * @param id
     * @return
     */
    @ResponseBody
	@RequestMapping(value = "${adminPath}/resource/delRsc", method = RequestMethod.GET)
	public String delRsc(@RequestParam("id")Integer id){
		String delFlag="fail";
		if(null!=id){
			ResourceInfo rsc=new ResourceInfo();
			rsc.setId(id);
			resourceService.delete(rsc);
			delFlag="success";
		}
		return delFlag;
	}
    
    /**
	 * 资源列表,根据当前页和记录数获取列表
	 * @param page 当前页
	 * @param rows 页面记录数
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("${adminPath}/resource/rscList")
	public  String rscList(int page,int rows,HttpServletRequest request) throws IOException{
		String name=WebUtils.getCleanParam(request,"name");
		String status=WebUtils.getCleanParam(request,"status");
		String resourceId=WebUtils.getCleanParam(request,"resourceId");
		ResourceInfo rsc=new ResourceInfo();
		if(null!=name||null!=status){
			if(null!=name){
				rsc.setName("%"+name+"%");
			}
			rsc.setStatus(status);
		}
		if(null!=resourceId){
			rsc.setId(Integer.valueOf(resourceId));
		}
		//求得开始记录与结束记录
		int start = (page-1)*rows;
		int end = page * rows;
		//把总记录和当前记录写到前台
		int total = resourceService.findListCount(rsc);
		rsc.getSqlMap().put("page", "limit "+start+","+end);
		List<ResourceInfo> uList = resourceService.findList(rsc);
		String json = JsonMapper.toJsonString(uList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
		return sb.toString();
	}

	@ResponseBody
	@RequestMapping("${adminPath}/resource/findBySubId")
	public  String findListBySubId(int page,int rows,HttpServletRequest request) throws IOException{
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
			int total = resourceService.findListCountBySubId(sqlMap);
			List<ResourceInfo> bList = resourceService.findListBySubId(sqlMap);
			String json = JsonMapper.toJsonString(bList);
			sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
			return sb.toString();
		}
		return "{\"total\":0,\"rows\":[]}";
	}
	
	@ResponseBody
	@RequestMapping("${adminPath}/resource/getListByBizId")
	public  String getListByBizId(int page,int rows,HttpServletRequest request) throws IOException{
		String businessId=WebUtils.getCleanParam(request,"businessId");
		StringBuffer sb=new StringBuffer();
		if(null!=businessId){
			//把总记录和当前记录写到前台
			Map<String,Object> sqlMap=new HashMap<String,Object>();
			//求得开始记录与结束记录
			int start = (page-1)*rows;
			int end = page * rows;
			sqlMap.put("page", "limit "+start+","+end);
			sqlMap.put("businessId", Integer.valueOf(businessId));
			int total = resourceService.findListCountByBizId(sqlMap);
			List<ResourceInfo> bList = resourceService.findListByBizId(sqlMap);
			String json = JsonMapper.toJsonString(bList);
			sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
			return sb.toString();
		}
		return "{\"total\":0,\"rows\":[]}";
	}
}
