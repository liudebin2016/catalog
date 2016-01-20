package com.jusfoun.catalog.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.entity.Office;
import com.jusfoun.catalog.entity.SearchLog;
import com.jusfoun.catalog.service.OfficeService;
import com.jusfoun.catalog.service.SearchLogService;

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
}
