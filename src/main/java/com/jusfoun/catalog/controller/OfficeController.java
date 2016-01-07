package com.jusfoun.catalog.controller;

import com.jusfoun.catalog.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 机构Controller
 * @author xuym
 *
 */
@Controller
public class OfficeController extends BaseController {


    @RequestMapping(value = "${adminPath}/office/info", method = RequestMethod.GET)
    public String info() {
        return "admin/office/info";
    }
    
    @RequestMapping(value = "${adminPath}/office/manage", method = RequestMethod.GET)
    public String manage(){
    	return "admin/office/manage";
    }
    
    @RequestMapping(value = "${adminPath}/office/maintenance", method = RequestMethod.GET)
    public String maintenance(){
    	return "admin/office/maintenance";
    }
}
