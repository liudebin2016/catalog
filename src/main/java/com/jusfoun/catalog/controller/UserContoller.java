package com.jusfoun.catalog.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.entity.DataEntity;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.common.servlet.ValidateCodeServlet;
import com.jusfoun.catalog.common.tool.IdGenTool;
import com.jusfoun.catalog.common.tool.ServletTool;
import com.jusfoun.catalog.entity.Dict;
import com.jusfoun.catalog.entity.Job;
import com.jusfoun.catalog.entity.Office;
import com.jusfoun.catalog.entity.Register;
import com.jusfoun.catalog.entity.ResourceInfo;
import com.jusfoun.catalog.entity.SubjectInfo;
import com.jusfoun.catalog.entity.User;
import com.jusfoun.catalog.service.SubjectService;
import com.jusfoun.catalog.service.SystemService;
import com.jusfoun.catalog.service.UserService;
import com.jusfoun.catalog.utils.LogUtils;
import com.jusfoun.catalog.utils.UserUtils;
import com.jusfoun.catalog.vo.CatalogTree;

/**
 * 主题目录
 * @author liudebin
 * 
 */
@Controller
public class UserContoller extends BaseController {
	
	@Autowired
	private UserService userService ;
	@Autowired
	private SystemService systemService;

	/**
	 * 主题目录信息列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/user/list", method = RequestMethod.GET)
	public String getUserInfoList(){
		
		return "admin/user/list";
	}
	/**
	 * 查询出用户列表
	 * @param page
	 * @param rows
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("${adminPath}/user/userList")
	public  String userList(int page,int rows,HttpServletRequest request) throws IOException{
		/*String label=WebUtils.getCleanParam(request,"label");
		String value=WebUtils.getCleanParam(request,"value");
		String id=WebUtils.getCleanParam(request,"id");
		String parentId=WebUtils.getCleanParam(request,"parentId");*/
		User user=new User();
		user.setDelFlag("0");
		/*if(null!=label||null!=label){
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
		}*/
		
		//求得开始记录与结束记录
		int start = (page-1)*rows+1;
		int end = page * rows;
		//把总记录和当前记录写到前台
		Long total = userService.findListCount(user);
		user.getSqlMap().put("start", String.valueOf(start));
		user.getSqlMap().put("end", String.valueOf(end));
		List<User> uList = userService.findUserList(user);
		String json = JsonMapper.toJsonString(uList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
		return sb.toString();
	}
	/**
	 * 创建
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/user/createUser", method = RequestMethod.POST)
	public String getCreateUser(HttpServletRequest request, HttpServletResponse response,Model model){
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String officeId = request.getParameter("officeId");
		Date createDate =new Date();
		User user = new User();
		
		user.setCreateBy(UserUtils.getUser());
		user.setCreateDate(createDate);
		user.setDelFlag("0");
		user.setName("部门管理员");
		user.setLoginName(name);
		user.setPassword(password);
		Office o = new Office();
		o.setId(Integer.parseInt(officeId));
		user.setOffice(o);
		user.setCompanyId(Integer.parseInt(officeId));
		int index = userService.createUser(user,officeId);
		LogUtils.saveLog(ServletTool.getRequest(), "创建用户");
		return "redirect:"+adminPath+"/user/list";
	}
	
	@RequestMapping(value = "${adminPath}/user/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public String deleteUser(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");//registerService
		String delFlag="fail";
		boolean flag=false;
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setDelFlag("1");
		if(userService.updateUser(user)){
			delFlag = "success";
		}
		return delFlag;
	}
	
	@RequestMapping(value = "${adminPath}/user/editPassword", method = RequestMethod.POST)
	@ResponseBody
	public String editPassword(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String loginName = request.getParameter("loginName");
		String delFlag="fail";
		systemService.updatePasswordById(Integer.parseInt(id), loginName, password);
		/*request.getSession().setAttribute(ValidateCodeServlet.VALIDATE_CODE, IdGenTool.uuid());
		LoginController.isValidateCodeLogin(loginName, false, true);*/
		User user = userService.get(Integer.parseInt(id));
		UserUtils.clearCache(user);
		delFlag = "success";
		return delFlag;
	}
	@RequestMapping(value = "${adminPath}/user/checkUserName", method = RequestMethod.POST)
	@ResponseBody
	public String checkUserName(HttpServletRequest request, HttpServletResponse response){
		String loginName = request.getParameter("loginName");
		String delFlag="nohave";
		boolean flag=false;
		User user = new User();
		user.setLoginName(loginName);
		if(userService.checkUserName(user)){
			delFlag = "ishave";
		}
		return delFlag;
	}
}