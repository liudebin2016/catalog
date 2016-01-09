package com.jusfoun.catalog.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.entity.Office;
import com.jusfoun.catalog.service.CatalogInfoService;
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
	@Resource
	private CatalogInfoService catalogInfoService;

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
			@RequestParam(name = "id", required = false) Integer id, 
			String name, 
			@RequestParam(name = "level", required = false) Integer level) {
		List<Office> officeListInDB = officeService.findAll();
		List<Office> resultList = new LinkedList<Office>();
		if (id == null) {
			// 加载一级域
			id = new Integer(0);
			level = new Integer(0);
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
					+ (level.intValue() < 2 ? "', isParent:true}" : ""));
		}
		sb.substring(0, sb.length() - 1);
		sb.append("]");
		return JSONObject.parse(sb.toString());
	}
    
    @RequestMapping(value = "${adminPath}/office/save", method = RequestMethod.POST)
    @ResponseBody
	public Object save(
			@RequestParam(name = "parentId", required = true) Integer parentId, 
			@RequestParam(name = "name", required = true) String name, 
			@RequestParam(name = "code", required = false) String code) {
    	if(StringUtils.isEmpty(name))
    		return null;
		officeService.insert(parentId, name.trim(), code.trim());
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("succ", 1);
		result.put("msg", "新增域成功!");
		return JSONObject.toJSON(result);
	}
    
    @RequestMapping(value = "${adminPath}/office/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(
    		@RequestParam(name = "id", required = true) Integer id) {
    	Office office = new Office();
    	office.setId(id);
    	officeService.delete(office);
    	Map<String,Object> result = new HashMap<String, Object>();
    	result.put("succ", 1);
    	result.put("msg", "删除域成功!");
    	return JSONObject.toJSON(result);
    }
    
}
