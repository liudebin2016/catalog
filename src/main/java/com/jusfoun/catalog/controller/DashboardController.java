package com.jusfoun.catalog.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.entity.Business;
import com.jusfoun.catalog.entity.Job;
import com.jusfoun.catalog.entity.Office;
import com.jusfoun.catalog.entity.ResourceInfo;
import com.jusfoun.catalog.entity.SearchLog;
import com.jusfoun.catalog.entity.SubjectInfo;
import com.jusfoun.catalog.service.BusinessService;
import com.jusfoun.catalog.service.JobService;
import com.jusfoun.catalog.service.OfficeService;
import com.jusfoun.catalog.service.ResourceService;
import com.jusfoun.catalog.service.SearchLogService;
import com.jusfoun.catalog.service.SubjectService;
import com.jusfoun.catalog.utils.UserUtils;

/**
 * Created by huanglei on 15/12/27.
 */
@Controller
public class DashboardController extends BaseController{

	@Resource
	private OfficeService officeService;
	@Resource
	private SearchLogService searchLogService;
//    @Autowired
//    private IUserService userService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private BusinessService businessService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private SubjectService subjectService;


    @RequestMapping(value = "${adminPath}/dashboard", method = RequestMethod.GET)
    public String loadAdminHomePage(Model m) {
        return "admin/dashboard";
    }


    @RequestMapping(value = "/")
    public String loadFrontHomePage() {
        return "index";
    }

    @RequestMapping(value = "/upgrade-your-browser")
    public String upgradeYourBrowser() {
        return "upgrade-your-browser";
    }

    @RequestMapping(value = "/upgrade-your-browser",method = RequestMethod.POST)
    public String login(){
        return "";
    }
    
    @RequestMapping(value = "/search",method = RequestMethod.POST)
	public String search(@RequestParam(value = "search_value", required=true) String value,
			@RequestParam(value = "search_type", required=true) int type,
			Model model) {
    	SearchLog log = new SearchLog();
    	log.setKeyword(value);
    	log.setSrhTime(new Date());
    	log.setSrhType(type);
    	searchLogService.save(log);
    	Map<String,Object> param = new HashMap<String, Object>();
    	param.put("duty", value.trim());
    	List<Office> officeList = officeService.queryOffices(param);
    	for(Office office : officeList)
    		office.setDuty(StringEscapeUtils.unescapeHtml4(office.getDuty().replaceAll(value.trim(), "&lt;span style='color:orange'&gt;"+value.trim()+"&lt;/span&gt;")));
    	model.addAttribute("officeList", officeList);
    	model.addAttribute("searchValue", value);
    	model.addAttribute("searchType", type);
		return "search";
	}
    
    @ResponseBody
    @RequestMapping(value = "/srh/jobDg")
    public String srhJobDg(int page,int rows,HttpServletRequest request){
    	String name=request.getParameter("name");
    	//求得开始记录与结束记录
		int start = (page-1)*rows;
		int end = page * rows;
		Job job=new Job();
		job.setName(name);
		job.getSqlMap().put("page", "limit "+start+","+end);
		int jobCount=jobService.findSrhListCount(job);
    	List<Job> jobList=jobService.findSrhList(job);
    	String json = JsonMapper.toJsonString(jobList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(jobCount).append(",\"rows\":").append(json).append("}");
    	return sb.toString();
    }
    
    @ResponseBody
    @RequestMapping(value = "/srh/bizDg")
    public String srhBizDg(int page,int rows,HttpServletRequest request){
    	//求得开始记录与结束记录
		int start = (page-1)*rows;
		int end = page * rows;
		Business biz=new Business();
		biz.setName(request.getParameter("name"));
		biz.getSqlMap().put("page", "limit "+start+","+end);
    	int bizCount=businessService.findSrhListCount(biz);
    	List<Business> bizList=businessService.findSrhList(biz);
    	String json = JsonMapper.toJsonString(bizList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(bizCount).append(",\"rows\":").append(json).append("}");
    	return sb.toString();
    }
    
    @ResponseBody
    @RequestMapping(value = "/srh/rscDg")
    public String rscJobDg(int page,int rows,HttpServletRequest request){
    	//求得开始记录与结束记录
		int start = (page-1)*rows;
		int end = page * rows;
		ResourceInfo rsc=new ResourceInfo();
		rsc.setName(request.getParameter("name"));
		rsc.getSqlMap().put("page", "limit "+start+","+end);
    	List<ResourceInfo> rscList=resourceService.findSrhList(rsc);
    	int rscCount=resourceService.findSrhListCount(rsc);
    	String json = JsonMapper.toJsonString(rscList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(rscCount).append(",\"rows\":").append(json).append("}");
    	return sb.toString();
    }
    
    @RequestMapping(value = "/srh/subDg")
    public String subJobDg(int page,int rows,SubjectInfo sub){
    	
    	return null;
    }
}