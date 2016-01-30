package com.jusfoun.catalog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.common.tool.ServletTool;
import com.jusfoun.catalog.entity.CatalogInfo;
import com.jusfoun.catalog.entity.Office;
import com.jusfoun.catalog.entity.User;
import com.jusfoun.catalog.service.CatalogInfoService;
import com.jusfoun.catalog.service.OfficeService;
import com.jusfoun.catalog.utils.LogUtils;
import com.jusfoun.catalog.utils.UserUtils;
import com.jusfoun.catalog.vo.CatalogTree;
import com.jusfoun.catalog.vo.ETreeNode;

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
    
    /**
     * 更新机构职责
     * @param id
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "${adminPath}/office/updateDuty")
    public String updateDuty(@RequestParam(value="id")Integer id,@RequestParam(value="content",required=false)String content,@RequestParam(value="status",required=false)String status) {
    	Office office=new Office();
    	office.setId(id);
    	if(content!=null&&!"".equals(content)){
    		office.setDuty(StringEscapeUtils.unescapeHtml4(content));
    	}
    	if(status!=null&&!"".equals(status)){
    		office.setStatus(status);
    	}
    	officeService.update(office);
    	LogUtils.saveLog(ServletTool.getRequest(), "部门目录-机构职责维护-编辑机构职责");
        return "success";
    }
    
    @RequestMapping(value = "${adminPath}/office/manage", method = RequestMethod.GET)
    public String manage(){
    	return "admin/office/manage";
    }
    
    @RequestMapping(value = "${adminPath}/office/maintenance", method = RequestMethod.GET)
    public ModelAndView maintenance(){
    	ModelAndView mav=new ModelAndView("admin/office/maintenance");
    	User user=UserUtils.getUser();
    	Integer sfd=user.getOffice().getId();
    	String ofcDuty=user.getOffice().getDuty();
    	if(null!=ofcDuty&&!"".equals(ofcDuty)){
    		mav.addObject("ofcDuty", StringEscapeUtils.unescapeHtml4(ofcDuty));
    	}else{
    		mav.addObject("ofcDuty", null);
    	}
    	mav.addObject("officeId", sfd);
    	return mav;
    }
    
    @RequestMapping(value = "${adminPath}/office/tree", method = RequestMethod.POST)
    @ResponseBody
	public Object tree() {
		return JsonMapper.toJsonString(officeService.getOfficeTree());
	}
    
    /**共享目录-四个模块左侧officeTree
     * 		->机构职责信息
     * 		->部门岗位信息
     * 		->业务目录信息
     * 		->资源目录信息
     * @return
     */
    @RequestMapping(value = "${adminPath}/office/officeTree", method = RequestMethod.POST)
    @ResponseBody
    public Object officeTree() {
    	List<Office> userOffices = UserUtils.getOfficeList();
    	List<CatalogTree> treeList = new ArrayList<CatalogTree>();
    	for(Office office : userOffices){
    		CatalogTree tree = new CatalogTree();
    		tree.setId(office.getId());
    		tree.setName(office.getName());
    		tree.setOpen(false);
    		tree.setParent(true);
    		if(office.getParent() == null )
    			tree.setpId(0);
			else
				tree.setpId(office.getParentId());
    		treeList.add(tree);
    	}
    	return JsonMapper.toJsonString(treeList);
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
		result.put("msg", "新增操作成功!");
		LogUtils.saveLog(ServletTool.getRequest(), "部门目录-机构职责维护-新增机构");
		return result;
	}
    
    @RequestMapping(value = "${adminPath}/office/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(
    		@RequestParam(name = "id", required = true) Integer id) {
    	officeService.delete(id);
    	Map<String,Object> result = new HashMap<String, Object>();
    	result.put("succ", 1);
    	result.put("msg", "删除操作成功!");
    	LogUtils.saveLog(ServletTool.getRequest(), "部门目录-机构职责维护-删除机构");
    	return result;
    }
    
    @RequestMapping(value = "${adminPath}/office/isUse", method = RequestMethod.POST)
    @ResponseBody
    public Object isUse(
    		@RequestParam(name = "id", required = true) Integer id,
    		@RequestParam(name = "status", required = true) String status) {
    	officeService.updateOfficeStatus(id, status);
    	Map<String,Object> result = new HashMap<String, Object>();
    	result.put("succ", 1);
    	result.put("msg", "更新操作成功!");
    	LogUtils.saveLog(ServletTool.getRequest(), "部门目录-机构职责维护-更新机构");
    	return result;
    }
    
    @RequestMapping(value = "${adminPath}/office/catalogInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object catalogInfo(
    		@RequestParam(name = "officeId", required = true) Integer officeId) {
    	CatalogInfo catalog = new CatalogInfo();
    	catalog.setOfficeId(officeId);
    	catalog.setType(CatalogInfo.TYPE_OFFICE);
    	CatalogInfo c = catalogInfoService.get(catalog);
    	Map<String,Object> result = new HashMap<String, Object>();
    	result.put("data", c);
    	return result;
    }
    
    @RequestMapping(value = "${adminPath}/office/update", method = RequestMethod.POST)
    @ResponseBody
	public Object update(
			@RequestParam(name = "parentId", required = true) Integer id, 
			@RequestParam(name = "name", required = true) String name, 
			@RequestParam(name = "code", required = false) String code) {
    	if(StringUtils.isEmpty(name))
    		return null;
		officeService.update(id,name.trim(),code.trim());
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("succ", 1);
		result.put("msg", "更新操作成功!");
		LogUtils.saveLog(ServletTool.getRequest(), "部门目录-机构职责维护-更新机构");
		return result;
	}
    
    @RequestMapping(value = "${adminPath}/office/drag", method = RequestMethod.POST)
    @ResponseBody
    public Object drag(
    		@RequestParam(name = "id", required = true) Integer id, 
    		@RequestParam(name = "targetId", required = true) Integer targetId, 
    		@RequestParam(name = "mt", required = true) String moveType) {
		officeService.drag(id, targetId, moveType);
    	Map<String,Object> result = new HashMap<String, Object>();
    	result.put("succ", 1);
    	result.put("msg", "更新操作成功!");
    	LogUtils.saveLog(ServletTool.getRequest(), "部门目录-机构职责维护-更新机构");
    	return result;
    }
    
    @RequestMapping(value = "${adminPath}/office/office", method = RequestMethod.POST)
    @ResponseBody
    public Object office(
    		@RequestParam(name = "officeId", required = true) Integer id) {
    	return JsonMapper.toJsonString(officeService.get(id));
    }
    
    @ResponseBody
    @RequestMapping(value = "build/eTreeNode")
    public String buildETreeNode(@RequestParam(name = "pid", required = false) Integer pid){
    	List<ETreeNode> etnList= officeService.buildETreeNode(pid==null?0:pid);
    	String entStr=JsonMapper.toJsonString(etnList);
    	return entStr;
    }
}
