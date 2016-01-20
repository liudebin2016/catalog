package com.jusfoun.catalog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.entity.Job;
import com.jusfoun.catalog.service.JobService;
import com.jusfoun.catalog.utils.UserUtils;
import com.jusfoun.catalog.vo.JobAndOfficeView;

/**
 * 部门岗位
 * @author liudebin
 * 
 */
@Controller
public class JobContoller extends BaseController {
	
	@Autowired
	private JobService jobService;

	/**
	 * 部门岗位信息列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/job/info", method = RequestMethod.GET)
	public String getJobInfoList(HttpServletRequest request, HttpServletResponse response,Model model){
		String name = request.getParameter("name");
		String office = request.getParameter("office");
		String office1 = request.getParameter("office");
		HashMap<String, String> cMap = new HashMap<String, String>();
		cMap.put("name", name);
		cMap.put("office", office);
		cMap.put("office1", office1);
		//当前只查询了job一张表，后期还要添加表
		try {
			List jobList = jobService.findJobByCondition(cMap);
			model.addAttribute("jobList", jobList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		model.addAttribute("cMap", cMap);
		return "admin/job/jobInfo";
	}
	
	/**
	 * 部门岗位维护
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/job/maintenance", method = RequestMethod.GET)
	public String getJobMaintenance(HttpServletRequest request, HttpServletResponse response){
		return "admin/job/jobMaintenance";
	}
	
	/**
	 * 部门岗位创建
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/job/create", method = RequestMethod.POST)
	public String getJobCreate(HttpServletRequest request, HttpServletResponse response,Model model){
		String name = request.getParameter("name");
		String duty = request.getParameter("duty");
		String type = request.getParameter("type");
		String status = request.getParameter("status");
		String officeId = request.getParameter("officeId");
		String[] businessId = request.getParameterValues("businessId");
		Date createDate =new Date();
		Job job = new Job();
		job.setName(name);
		job.setDuty(duty);
		job.setType(type);
		job.setStatus(status);
		job.setCreateBy(UserUtils.getUser());
		job.setCreateDate(createDate);
		job.setDelFlag("0");
		job.setOfficeId(Integer.parseInt(officeId));
		int index = jobService.createJob(job,officeId,businessId);
		return "redirect:"+adminPath+"/job/maintenance";
	}
	
	/**
	 * 岗位目录管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/job/manage", method = RequestMethod.GET)
	public String getJobManage(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/job/jobManage";
	}
	
	/**
	 * 部门岗位编辑
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/job/edit", method = RequestMethod.GET)
	public String getJobEdit(HttpServletRequest request, HttpServletResponse response,Model model){
		String id = request.getParameter("id");
		Job job =jobService.selectById(id);
		model.addAttribute("job",job);
		return "admin/job/jobEdit";
	}
	
	/**
	 * 部门岗位新建按钮
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/job/addjob", method = RequestMethod.GET)
	public String getJobAdd(HttpServletRequest request, HttpServletResponse response,Model model){
		Job job = new Job();
		model.addAttribute("job", job);
		return "admin/job/jobEdit";
	}
	/**
	 * 部门岗位编辑
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/job/doedit", method = RequestMethod.POST)
	public String getJobDoEdit(HttpServletRequest request, HttpServletResponse response,Job job,Model model){
		String officeId=WebUtils.getCleanParam(request,"officeId");
		String businessId=WebUtils.getCleanParam(request,"businessId");
		HashMap<String, Object> cMap = new HashMap<String, Object>();
		cMap.put("officeId", officeId);
		cMap.put("businessId", businessId);
		cMap.put("jobId", job.getId());
		job.setUpdateBy(UserUtils.getUser());
		job.setUpdateDate(new Date());
		boolean flag = jobService.updateById(job,cMap);
		return "redirect:"+adminPath+"/job/maintenance";
	}
	
	/**
	 * 资源列表,根据当前页和记录数获取列表
	 * @param page 当前页
	 * @param rows 页面记录数
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("${adminPath}/job/reloadList")
	public  String reloadList(int page,int rows,HttpServletRequest request) throws IOException{
		String name=WebUtils.getCleanParam(request,"name");
		String status=WebUtils.getCleanParam(request,"status");
		Job job=new Job();
		if(null!=name||null!=status){
			if(null!=name){
				job.setName("%"+name+"%");
			}
			job.setStatus(status);
		}
		//求得开始记录与结束记录
		int start = (page-1)*rows;
		int end = page * rows;
		//把总记录和当前记录写到前台
		int total = jobService.findListCount(job);
		job.getSqlMap().put("page", "limit "+start+","+end);
		List<JobAndOfficeView>jobList = jobService.findJobList(job);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(jobList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
		return sb.toString();
	}
	
	/**
	 * 岗位目录删除
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/job/delJobById", method = RequestMethod.GET)
	public String delJobById(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String delFlag="fail";
		if(null!=id){
			Job job=new Job();
			job.setId(Integer.parseInt(id));
			int temp = jobService.deleteById(job);
			delFlag="success";
		}
		return delFlag;
		
		//return "redirect:"+adminPath+"/job/maintenance";
	}
	
	/**
	 * 资源列表,根据当前页和记录数获取列表根据officeid查询的
	 * @param page 当前页
	 * @param rows 页面记录数
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("${adminPath}/job/reloadListByOfficeId")
	public  String reloadListByOfficeId(int page,int rows,HttpServletRequest request,@RequestParam("ids[]") List<Integer> ids) throws IOException{
		String name=WebUtils.getCleanParam(request,"name");
		String officeId=WebUtils.getCleanParam(request,"officeId");
		String type=WebUtils.getCleanParam(request,"type");
		JobAndOfficeView job=new JobAndOfficeView();
		if(null!=name|| null != type){
			if(null!=name){
				job.setJobName("%"+name+"%");
			}
			job.setJobType(type);
			
		}
		if(null!=officeId){
			job.setOfficeId(Integer.parseInt(officeId));
		}else{
//			job.setOfficeId(1);
		}
		if(ids.size() !=0){
			if(ids.get(0)!= -100){
				job.setOfficeIds(ids);
			}else{
				job.setOfficeIds(new ArrayList<Integer>());
			}
		}
		
		//求得开始记录与结束记录
		int start = (page-1)*rows;
		int end = page * rows;
		//把总记录和当前记录写到前台
		int total = jobService.findListCountByOfficeId(job);
		job.getSqlMap().put("page", "limit "+start+","+end);
		List<JobAndOfficeView>jobList = jobService.findJobListByOfficeId(job);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(jobList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
		return sb.toString();
	}
	
	/**
	 * 岗位提交申请
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/job/jobApplyFor", method = RequestMethod.GET)
	public String jobApplyFor(HttpServletRequest request, HttpServletResponse response){
		String ids = request.getParameter("ids");
		String delFlag="fail";
		if(ids != null){
			int temp = jobService.jobApplyFor(ids);
			delFlag="success";
		}
		return delFlag;
		
		//return "redirect:"+adminPath+"/job/maintenance";
	}
}
