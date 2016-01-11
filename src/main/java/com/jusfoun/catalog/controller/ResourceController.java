package com.jusfoun.catalog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.entity.Page;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.entity.ResourceInfo;
import com.jusfoun.catalog.service.ResourceService;
import com.jusfoun.catalog.vo.CatalogTree;

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
    
    @RequestMapping(value = "${adminPath}/resource/action", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("type")String type,@RequestParam(value="id",required=false) Integer id) {
    	ModelAndView mav=new ModelAndView("admin/resource/edit");
    	if(null!=type&&!"".equals(type)&&type.equals("update")){
    		if(null!=id){
    			ResourceInfo rscInfo=resourceService.get(id);
    			if(null!=rscInfo){
    				mav.addObject("rsc", rscInfo);
    			}
    		}
    	}else{
    		mav.addObject("rsc", null);
    	}
    	return mav;
    }
    
    @RequestMapping(value = "${adminPath}/resource/doCreate", method = RequestMethod.POST)
    public String rscDoCreate(ResourceInfo rsc) {
    	System.out.println(4535);
    	resourceService.save(rsc);
    	return adminPath+"/resource/maintenance";
    }
    
    /**
     * 维护资源
     * @param request
     * @return
     */
    @RequestMapping(value = "${adminPath}/resource/maintenance")
    public ModelAndView maintenance(HttpServletRequest request){
    	ModelAndView mav=new ModelAndView("admin/resource/maintenance");
    	String name=WebUtils.getCleanParam(request,"name");
		String status=WebUtils.getCleanParam(request,"status");
		ResourceInfo rsc=new ResourceInfo();
		if(null!=name||null!=status){
			if(null!=name){
				rsc.setName("%"+name+"%");
			}
			rsc.setStatus(status);
		}
		Page<ResourceInfo> bPage=new Page<ResourceInfo>();
		bPage.setPageNo(0);
		bPage.setPageSize(5);
		rsc.getSqlMap().put("dsf", "limit "+bPage.getPageNo()+","+bPage.getPageSize());
		Page<ResourceInfo> bizPage=resourceService.findPage(bPage, rsc);
		mav.addObject("page", bizPage);
    	return mav;
    }
    
    /**
     * 删除资源
     * @param id
     * @return
     */
    @ResponseBody
	@RequestMapping(value = "${adminPath}/resource/delRsc", method = RequestMethod.GET)
	public String delRsc(@RequestParam("id")Integer id){
		String delFlag="fail";
		if(null!=id){
			ResourceInfo rsc=new ResourceInfo();
			rsc.setId(id);
			resourceService.delete(rsc);
			delFlag="success";
		}
		return delFlag;
	}
}
