package com.jusfoun.catalog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jusfoun.catalog.common.controller.BaseController;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.entity.Register;
import com.jusfoun.catalog.service.RegisterService;

/**
 * 注册申请、注册审批
 * @author liudebin
 * 
 */
@Controller
public class RegisterContoller extends BaseController {

	@Resource
	private RegisterService registerService;
	/**
	 * 注册申请
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/register/applyIndex", method = RequestMethod.GET)
	public String applyIndex(HttpServletRequest request, HttpServletResponse response){
		return "admin/register/apply";
	}
	
	/**
	 * 注册申请
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/register/approveIndex", method = RequestMethod.GET)
	public String approveIndex(HttpServletRequest request, HttpServletResponse response){
		return "admin/register/approve";
	}
	
	/**
	 * 注册申请
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "${adminPath}/register/apply", method = RequestMethod.GET)
	@ResponseBody
	public Object apply(@RequestParam(value="applyId", required=true) Integer applyId,
			@RequestParam(value = "applyType", required = true) Integer applyType) {
		registerService.apply(applyId,applyType);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("succ", 1);
		result.put("msg", "申请注册成功！");
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "${adminPath}/register/applyList")
	public  String applyList(int page,int rows,HttpServletRequest request) throws IOException{
		String applyName=WebUtils.getCleanParam(request,"applyName");
		String applyType=WebUtils.getCleanParam(request,"applyType");
		String status=WebUtils.getCleanParam(request,"status");
		Register register=new Register();
		if(!StringUtils.isEmpty(applyName)){
			register.setApplyName(applyName);
		}
		if(!StringUtils.isEmpty(applyType)){
			register.setApplyType(Integer.valueOf(applyType));
		}
		if(!StringUtils.isEmpty(status)){
			register.setApplyFlag(status);
		}
		//求得开始记录与结束记录
		int start = (page-1)*rows+1;
		int end = page * rows;
		//把总记录和当前记录写到前台
		int total = registerService.findListCount(register);
		register.getSqlMap().put("start", ""+start);
		register.getSqlMap().put("end", ""+end);
		List<Register> pageList = registerService.findList(register);
		String json = JsonMapper.toJsonString(pageList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
		return sb.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "${adminPath}/register/approveList", method = RequestMethod.POST)
	public  String approveList(int page,int rows,HttpServletRequest request) throws IOException{
		String applyName=WebUtils.getCleanParam(request,"applyName");
		String applyType=WebUtils.getCleanParam(request,"applyType");
		String status=WebUtils.getCleanParam(request,"status");
		Register register=new Register();
		if(!StringUtils.isEmpty(applyName)){
			register.setApplyName(applyName);
		}
		if(!StringUtils.isEmpty(applyType)){
			register.setApplyType(Integer.valueOf(applyType));
		}
		if(!StringUtils.isEmpty(status)){
			register.setApplyFlag(status);
		}
		// 只查询待审批状态数据 
		register.setApproveFlag(Register.STATUS_APPROVALING);
		
		int start = (page-1)*rows+1;
		int end = page * rows;
		int total = registerService.findListCount(register);
		register.getSqlMap().put("start", ""+start);
		register.getSqlMap().put("end", ""+end);
		List<Register> pageList = registerService.findList(register);
		String json = JsonMapper.toJsonString(pageList);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"total\":").append(total).append(",\"rows\":").append(json).append("}");
		return sb.toString();
	}
	
	@RequestMapping(value = "${adminPath}/register/approved", method = RequestMethod.POST)
	@ResponseBody
	public Object approved(@RequestParam(value="id", required=true) Integer id,
			@RequestParam(value = "flag", required = true) Integer flag) {
		registerService.approve(id,flag.intValue()==0 ? Register.STATUS_APPROVED : Register.STATUS_UNAPPROVAL);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("succ", 1);
		result.put("msg", "审批成功！");
		return result;
	}
}
