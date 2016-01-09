package com.jusfoun.catalog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.entity.Page;
import com.jusfoun.catalog.dao.JobDao;
import com.jusfoun.catalog.entity.Job;
import com.jusfoun.catalog.service.JobService;
import com.jusfoun.catalog.utils.UserUtils;

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
	public String getJobInfoList(HttpServletRequest request, HttpServletResponse response){
		
		return "admin/job/jobInfo";
	}
	
	/**
	 * 部门岗位维护
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/job/maintenance", method = RequestMethod.GET)
	public String getJobMaintenance(HttpServletRequest request, HttpServletResponse response,Model model){
		List<Job>jobList = jobService.findJobList();
		model.addAttribute("jobList", jobList);
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
		Date createDate =new Date();
		Job job = new Job();
		job.setName(name);
		job.setDuty(duty);
		job.setType(type);
		job.setCreateBy(UserUtils.getUser());
		job.setCreateDate(createDate);
		job.setDelFlag("0");
		int index = jobService.createJob(job);
		return getJobMaintenance(request, response, model);
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
		job.setUpdateBy(UserUtils.getUser());
		job.setUpdateDate(new Date());
		boolean flag = jobService.updateById(job);
		return getJobMaintenance(request, response, model);
	}
}
