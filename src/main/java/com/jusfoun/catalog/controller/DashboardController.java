package com.jusfoun.catalog.controller;


import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jusfoun.catalog.common.controller.BaseController;
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
			@RequestParam(value = "search_type", required=true) int type) {
    	SearchLog log = new SearchLog();
    	log.setKeyword(value);
    	log.setSrhTime(new Date());
    	log.setSrhType(type);
    	searchLogService.save(log);
		return "search";
	}
}
