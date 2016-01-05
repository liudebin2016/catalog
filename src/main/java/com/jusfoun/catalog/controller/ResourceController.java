package com.jusfoun.catalog.controller;

import com.jusfoun.catalog.common.controller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 资源Controller
 * @author admin
 *
 */
@Controller
public class ResourceController extends BaseController {
    
    @RequestMapping(value = "${adminPath}/resource/manage", method = RequestMethod.GET)
    public String manage(){
    	return "admin/resource/manage";
    }
    
    @RequestMapping(value = "${adminPath}/resource/index", method = RequestMethod.GET)
    public String index() {
    	return "admin/resource/index";
    }
    
    @RequestMapping(value = "${adminPath}/resource/edit", method = RequestMethod.GET)
    public String edit() {
    	return "admin/resource/edit";
    }
    
    @RequestMapping(value = "${adminPath}/resource/maintenance", method = RequestMethod.GET)
    public String maintenance(){
    	return "admin/resource/maintenance";
    }
}
