package com.jusfoun.catalog.controller;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.entity.ResourceInfo;
import com.jusfoun.catalog.service.ResourceService;
import com.jusfoun.catalog.vo.CatalogTree;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 资源Controller
 * @author admin
 *
 */
@Controller
public class ResourceController extends BaseController {
	
	@Autowired
	private ResourceService resourceService;
    
	/**
	 * 资源目录管理
	 * @return
	 */
    @RequestMapping(value = "${adminPath}/resource/manage", method = RequestMethod.GET)
    public ModelAndView manage(){
    	ModelAndView mav=new ModelAndView("admin/resource/manage");
    	List<CatalogTree> ctList=resourceService.getResourceCatalogTree(null);
    	String ctListJson=JsonMapper.toJsonString(ctList);
    	mav.addObject("ctListJson", ctListJson);
    	return mav;
    }
    
    @RequestMapping(value = "${adminPath}/resource/index", method = RequestMethod.GET)
    public String index() {
    	return "admin/resource/index";
    }
    
    @RequestMapping(value = "${adminPath}/resource/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("type")String type) {
    	ModelAndView mav=new ModelAndView("admin/resource/edit");
    	if(null!=null&&!"".equals(type)){
    		if(!type.equals("create")){
    			
    		}
    	}
    	return mav;
    }
    
    @RequestMapping(value = "${adminPath}/resource/doCreate", method = RequestMethod.POST)
    public String rscDoCreate(ResourceInfo rsc) {
    	System.out.println(4535);
    	resourceService.save(rsc);
    	return adminPath+"/resource/maintenance";
    }
    
    @RequestMapping(value = "${adminPath}/resource/maintenance", method = RequestMethod.GET)
    public String maintenance(){
    	return "admin/resource/maintenance";
    }
}
