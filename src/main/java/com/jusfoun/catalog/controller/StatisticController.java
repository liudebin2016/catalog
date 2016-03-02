package com.jusfoun.catalog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.entity.Statistic;
import com.jusfoun.catalog.service.SearchLogService;
import com.jusfoun.catalog.service.StatisticService;
import com.jusfoun.catalog.vo.SearchAnalysis;

/**
 * 统计Controller
 * @author Connor
 * @version 2015-12-28
 */
@Controller
public class StatisticController extends BaseController {

	@Resource
	private StatisticService statisticService;
	@Resource
	private SearchLogService searchLogService;

    @RequestMapping(value = "${adminPath}/statistic/search", method = RequestMethod.GET)
    public ModelAndView getSearchCountPage() {
    	ModelAndView mav=new ModelAndView("admin/statistic/search");
    	List<String> hoy=searchLogService.getHalfOfYearRshTime();
    	mav.addObject("xAxis_data", hoy.toString());
    	System.out.println(hoy.toString());
    	List<String> rtbt=searchLogService.getRshTypeByTime();
    	System.out.println(rtbt.toString());
    	mav.addObject("legend_data", rtbt.toString()
    			.replace("1", "'机构'")
    			.replace("2", "'岗位'")
    			.replace("3", "'业务'")
    			.replace("4", "'资源'")
    			.replace("5", "'主题'"));
    	List<SearchAnalysis> salist=searchLogService.getRshDataByTime(hoy.size()*rtbt.size());
    	Map<String,List<String>> sdf=new HashMap<String,List<String>>();
    	for(SearchAnalysis sa:salist){
    		List<String> dsd=null;
    		if(sa.getSrhType()==1){
    			if(sdf.containsKey("机构")){
    				dsd=sdf.get("机构");
    				dsd.add(String.valueOf(sa.getSrhCount()));
    			}else{
    				dsd=new ArrayList<String>();
    				dsd.add(String.valueOf(sa.getSrhCount()));
    				sdf.put("机构", dsd);
    			}
    		}else if(sa.getSrhType()==2){
    			if(sdf.containsKey("岗位")){
    				dsd=sdf.get("岗位");
    				dsd.add(String.valueOf(sa.getSrhCount()));
    			}else{
    				dsd=new ArrayList<String>();
    				dsd.add(String.valueOf(sa.getSrhCount()));
    				sdf.put("岗位", dsd);
    			}
    		}else if(sa.getSrhType()==3){
    			if(sdf.containsKey("业务")){
    				dsd=sdf.get("业务");
    				dsd.add(String.valueOf(sa.getSrhCount()));
    			}else{
    				dsd=new ArrayList<String>();
    				dsd.add(String.valueOf(sa.getSrhCount()));
    				sdf.put("业务", dsd);
    			}
    		}else if(sa.getSrhType()==4){
    			if(sdf.containsKey("资源")){
    				dsd=sdf.get("资源");
    				dsd.add(String.valueOf(sa.getSrhCount()));
    			}else{
    				dsd=new ArrayList<String>();
    				dsd.add(String.valueOf(sa.getSrhCount()));
    				sdf.put("资源", dsd);
    			}
    		}else if(sa.getSrhType()==5){
    			if(sdf.containsKey("主题")){
    				dsd=sdf.get("主题");
    				dsd.add(String.valueOf(sa.getSrhCount()));
    			}else{
    				dsd=new ArrayList<String>();
    				dsd.add(String.valueOf(sa.getSrhCount()));
    				sdf.put("主题", dsd);
    			}
    		}
    	}
    	
    	System.out.println("通过Map.entrySet遍历key和value");
    	StringBuffer sb=new StringBuffer();
	    for (Entry<String, List<String>> entry : sdf.entrySet()) {
	    	sb.append("{name:'").append(entry.getKey()).append("',type:'line',stack: '总量',data:").append(entry.getValue().toString()).append("},");
	    }
	    System.out.println(sb.toString());
    	String data=sb.toString();
    	mav.addObject("data", data.substring(0,data.lastIndexOf(",")));
        return mav;
    }

    @RequestMapping(value = "${adminPath}/statistic/info", method = RequestMethod.GET)
    public String info(Model model) {
    	Map<String,String> counts = statisticService.getAllModuleCount();
    	model.addAttribute("counts", counts);
        return "admin/statistic/info";
    }
    
	@ResponseBody
	@RequestMapping(value = "${adminPath}/statistic/list", method = RequestMethod.POST)
	public  String list(int page,int rows,HttpServletRequest request) throws IOException{
		return null;
	}
	
	/**
	 * 信息统计
	 * @param page 当前页
	 * @param rows 页面记录数
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("${adminPath}/statistic/statb")
	public  String statisticList(int page,int rows,HttpServletRequest request) throws IOException{
		//求得开始记录与结束记录
		int start = (page-1)*rows+1;
		int end = page * rows;
		//把总记录和当前记录写到前台
		int total = statisticService.findListCount();
		Map<String,Integer> paraMaps=new HashMap<String,Integer>();
		paraMaps.put("start",start);
		paraMaps.put("end", end);
		List<Statistic> uList = statisticService.findList(paraMaps);
		String json = JsonMapper.toJsonString(uList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
		return sb.toString();
	}
    
}
