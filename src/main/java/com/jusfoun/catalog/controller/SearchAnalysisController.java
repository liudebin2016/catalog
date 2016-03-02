package com.jusfoun.catalog.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.common.tool.DateTool;
import com.jusfoun.catalog.service.SearchLogService;
import com.jusfoun.catalog.vo.SearchAnalysis;

/**
 * 检索统计
 * @author liudebin
 *
 */
@Controller
public class SearchAnalysisController {
	
	@Autowired
	private SearchLogService searchLogService;
	
	/**
	 * 热词排行
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "${adminPath}/srh/hotwords")
	public String search4HotWord(@RequestParam("type") String type){
		Map<String,Date> paraMaps=new HashMap<String,Date>();
    	
		Date endTime = new Date();   //当前时间
    	Date beginTime =null;
    	if(type.equals("week")){
    		beginTime =DateTool.getBeforOrAfterDate(endTime,-7);
    	}else if(type.equals("month")){
    		beginTime =DateTool.getBeforOrAfterDate(endTime,-30);
    	}else{
    		beginTime =DateTool.getBeforOrAfterDate(endTime,-365);
    	}

    	paraMaps.put("beginTime", beginTime);
    	paraMaps.put("endTime", endTime);
		List<SearchAnalysis> sal=searchLogService.hotWord(paraMaps);
		String retVal=JsonMapper.toJsonString(sal);
		return retVal;
	}
	
	/**
	 * 热门机构
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "${adminPath}/srh/hotOffices")
	public String search4HotOffice(@RequestParam("type") String type){
		Map<String,Date> paraMaps=new HashMap<String,Date>();
    	
    	Date endTime = new Date();   //当前时间
    	Date beginTime =null;
    	if(type.equals("week")){
    		beginTime =DateTool.getBeforOrAfterDate(endTime,-7);
    	}else if(type.equals("month")){
    		beginTime =DateTool.getBeforOrAfterDate(endTime,-30);
    	}else{
    		beginTime =DateTool.getBeforOrAfterDate(endTime,-365);
    	}

    	paraMaps.put("beginTime", beginTime);
    	paraMaps.put("endTime", endTime);
		List<SearchAnalysis> sal=searchLogService.hotOffice(paraMaps);
		String retVal=JsonMapper.toJsonString(sal);
		return retVal;
	}
	
}
