package com.jusfoun.catalog.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jusfoun.catalog.common.controller.BaseController;
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
	@RequestMapping(value = "${adminPath}/register/list", method = RequestMethod.POST)
	public  String list(int page,int rows,HttpServletRequest request) throws IOException{
		return null;
	}
    
}
