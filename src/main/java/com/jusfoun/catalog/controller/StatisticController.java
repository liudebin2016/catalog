package com.jusfoun.catalog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.entity.Statistic;
import com.jusfoun.catalog.service.StatisticService;

/**
 * 统计Controller
 * @author Connor
 * @version 2015-12-28
 */
@Controller
public class StatisticController extends BaseController {

	@Resource
	private StatisticService statisticService;

    @RequestMapping(value = "${adminPath}/statistic/search", method = RequestMethod.GET)
    public String getSearchCountPage() {
        return "admin/statistic/search";
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
