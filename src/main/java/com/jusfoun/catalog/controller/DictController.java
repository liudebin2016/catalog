package com.jusfoun.catalog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.entity.Dict;
import com.jusfoun.catalog.service.DictService;

/**
 * 统计Controller
 * @author Connor
 * @version 2015-12-28 18:19:00
 */
@Controller
public class DictController extends BaseController{
	
	@Autowired
	private DictService dictService;

    /**
     * 显示字典列表页面
     *
     */
    @RequestMapping(value = "${adminPath}/dict/list")
    public String getDictListPage() {
        return "admin/dict/list";
    }
    
    /**
     * 显示字典列表页面
     *
     */
    @RequestMapping(value = "${adminPath}/dict/subList")
    public ModelAndView subListPage(Dict dict) {
    	ModelAndView mav=new ModelAndView("admin/dict/sublist");
    	mav.addObject(dict);
        return mav;
    }
    
    /**
     * 创建字典
     * @param rsc
     * @return
     */
    @RequestMapping(value = "${adminPath}/dict/createDict", method = RequestMethod.POST)
    public String createDict(Dict dict,RedirectAttributes attr) {
    	if(dict.getId()!=null){
    		dictService.update(dict);
    	}else{
    		dictService.save(dict);
    	}
    	String reVal="redirect:/admin/dict/list";
    	if(dict.getParentId()!=null){
    		Dict d=dictService.get(Integer.valueOf(dict.getParentId()));
    		attr.addFlashAttribute(d);
    		reVal="redirect:/admin/dict/subList";
    	}
    	return reVal;
    }
    
    /**
	 * 业务列表,根据当前页和记录数获取列表
	 * @param page 当前页
	 * @param rows 页面记录数
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("${adminPath}/dict/dictList")
	public  String dictList(int page,int rows,HttpServletRequest request) throws IOException{
		String label=WebUtils.getCleanParam(request,"label");
		String value=WebUtils.getCleanParam(request,"value");
		String id=WebUtils.getCleanParam(request,"id");
		String parentId=WebUtils.getCleanParam(request,"parentId");
		Dict dict=new Dict();
		if(null!=label||null!=label){
			if(null!=label){
				dict.setLabel(label);
			}
		}
		if(null!=value||null!=value){
			if(null!=value){
				dict.setValue(value);
			}
		}		
		if(null!=id){
			dict.setId(Integer.valueOf(id));
		}
		
		if(null!=parentId){
			dict.setParentId(parentId);
		}
		
		//求得开始记录与结束记录
		int start = (page-1)*rows;
		int end = page * rows;
		//把总记录和当前记录写到前台
		int total = dictService.findListCount(dict);
		dict.getSqlMap().put("start", String.valueOf(start));
		dict.getSqlMap().put("end", String.valueOf(end));
		List<Dict> uList = dictService.findList(dict);
		String json = JsonMapper.toJsonString(uList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
		return sb.toString();
	}
}
