package com.jusfoun.catalog.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.entity.Office;
import com.jusfoun.catalog.service.OfficeService;

/**
 * 机构Controller
 * @author xuym
 *
 */
@Controller
public class OfficeController extends BaseController {
	
	@Resource
	private OfficeService officeService;

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
    
    @RequestMapping(value = "${adminPath}/office/tree", method = RequestMethod.POST)
    @ResponseBody
	public Object tree(
			@RequestParam(name = "id", required = false) Integer id, Model model) {
		List<Office> officeListInDB = officeService.findAll();
		List<Office> resultList = new LinkedList<Office>();
		if (id == null) {
			// 加载一级域
			id = new Integer(0);
		}
		for (Office ofc : officeListInDB) {
			if (ofc.getParentId().intValue() == id.intValue())
				resultList.add(ofc);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Office office : resultList) {
			// { id:1, pId:0, name:"父节点1", open:true,isParent:true},
			sb.append("{ id:" + office.getId() + ", pId:"
					+ office.getParentId() + ", name:'" + office.getName()
					+ "', isParent:true}");
		}
		sb.substring(0, sb.length() - 1);
		sb.append("]");
		model.addAttribute("zNodes", JSONObject.parse(sb.toString()));
		return JSONObject.parse(sb.toString());
	}
}
