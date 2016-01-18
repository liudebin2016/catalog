package com.jusfoun.catalog.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.service.LogService;
import com.jusfoun.catalog.vo.LogAndUserView;

/**
 * 日志Controller
 * @author Connor
 * @version 2015-12-28 18:19:00
 */
@Controller
public class LogController extends BaseController {
	
	@Autowired
	private LogService logService;

    /**
     * 显示日志列表页面
     *
     */
    @RequestMapping(value = "${adminPath}/log/list", method = RequestMethod.GET)
    public String getDictListPage() {
        return "admin/log/list";
    }
    

    /**
     * 显示日志列表
     * @throws ParseException 
     * @throws JsonProcessingException 
     *
     */
    @ResponseBody
	@RequestMapping("${adminPath}/log/reloadList")
	public  String reloadList(int page,int rows,HttpServletRequest request) throws ParseException, JsonProcessingException{
    	String userName=WebUtils.getCleanParam(request,"userName");
		String beginDate=WebUtils.getCleanParam(request,"beginDate");
		String endDate=WebUtils.getCleanParam(request,"endDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		LogAndUserView log = new LogAndUserView();
		if(userName!=null){
			log.setUserName("%"+userName+"%");
		}
		if(beginDate !=null){
			Date formatBegin = sdf.parse(beginDate);
			log.setLogBeginDate(formatBegin);
		}
		if(endDate != null){
			Date formatEndDate=sdf.parse(endDate);
			log.setLogEndDate(formatEndDate);
		}
		//求得开始记录与结束记录
		int start = (page-1)*rows;
		int end = rows;
		int total = logService.reloadLogListCount(log);
		log.getSqlMap().put("page", "limit "+start+","+end);
    	List<LogAndUserView> logList = logService.reloadList(log);
    	ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(logList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
		return sb.toString();
    }
}
