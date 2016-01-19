package com.jusfoun.catalog.controller;


import com.jusfoun.catalog.common.controller.BaseController;
        import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by huanglei on 15/12/27.
 */
@Controller
public class DashboardController extends BaseController{


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
    
    @RequestMapping(value = "/search")
    public String search() {
        return "search";
    }

}
