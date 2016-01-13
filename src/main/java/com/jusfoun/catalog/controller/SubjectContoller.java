package com.jusfoun.catalog.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.entity.ResourceInfo;
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
	public String getSubjectInfoList(){
		
		return "admin/subject/subjectIndex";
	}
	
	/**
	 * 主题目录操作控制（创建还是修改？）
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/action", method = RequestMethod.GET)
	public ModelAndView action(@RequestParam("type") String type,@RequestParam(value="subjectId",required=false) Integer subjectId){
		ModelAndView mav = new ModelAndView("admin/subject/subjectAction");
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
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/doCreate", method = RequestMethod.POST)
	public String getSubjectDoCreate(HttpServletRequest request){
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
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/doUpdate", method = RequestMethod.POST)
	public String getSubjectDoUpdate(HttpServletRequest request){
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
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/subject/link", method = RequestMethod.GET)
	public String getSubjectLink(){
		
		return "admin/subject/subjectLink";
	}
	
	/**
	 * 根据父id查询其下的子主题
	 * @param pid
	 * @return
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping(value="${adminPath}/subject/getListById",method=RequestMethod.GET)
	public String getSubListByPid(@RequestParam(value="pid",required=false)Integer pid,@RequestParam(value="subjectId",required=false)Integer subjectId) throws JsonProcessingException{
		SubjectInfo si=new SubjectInfo();
		if(null!=pid){
			si.setParentId(pid);		
		}
		if(null!=subjectId){
			si.setId(subjectId);
		}
		List<SubjectInfo> siList=subjectService.findList(si);
		String json = JsonMapper.toJsonString(siList);
		return json;
	}
	
	/**
	 * 根据业务Id查询主题
	 * @param pid
	 * @return
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping(value="${adminPath}/subject/getSubListByBizId",method=RequestMethod.GET)
	public String getSubListByBizId(int page,int rows,@RequestParam(value="businessId",required=false)Integer businessId) throws JsonProcessingException{
		StringBuffer sb=new StringBuffer();
		if(null!=businessId){
			//把总记录和当前记录写到前台
			Map<String,Object> sqlMap=new HashMap<String,Object>();
			//求得开始记录与结束记录
			int start = (page-1)*rows;
			int end = page * rows;
			sqlMap.put("page", "limit "+start+","+end);
			sqlMap.put("businessId", Integer.valueOf(businessId));
			int total = subjectService.findListCountByBizId(sqlMap);
			List<ResourceInfo> bList = subjectService.findListByBizId(sqlMap);
			String json = JsonMapper.toJsonString(bList);
			sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
			return sb.toString();
		}
		return "{\"total\":0,\"rows\":[]}";
	}
	
	/**
	 * 根据业务Id查询主题
	 * @param pid
	 * @return
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping(value="${adminPath}/subject/getSubListByRscId",method=RequestMethod.GET)
	public String getSubListByRscId(int page,int rows,@RequestParam(value="resourceId",required=false)Integer resourceId) throws JsonProcessingException{
		StringBuffer sb=new StringBuffer();
		if(null!=resourceId){
			//把总记录和当前记录写到前台
			Map<String,Object> sqlMap=new HashMap<String,Object>();
			//求得开始记录与结束记录
			int start = (page-1)*rows;
			int end = page * rows;
			sqlMap.put("page", "limit "+start+","+end);
			sqlMap.put("resourceId", resourceId);
			int total = subjectService.findListCountByRscId(sqlMap);
			List<ResourceInfo> bList = subjectService.findListByRscId(sqlMap);
			String json = JsonMapper.toJsonString(bList);
			sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
			return sb.toString();
		}
		return "{\"total\":0,\"rows\":[]}";
	}
	
}