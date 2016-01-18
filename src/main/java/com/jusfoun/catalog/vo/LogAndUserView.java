package com.jusfoun.catalog.vo;

import java.util.Date;

import com.jusfoun.catalog.common.entity.DataEntity;

public class LogAndUserView  extends DataEntity<LogAndUserView>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String logType; 		// 日志类型（1：接入日志；2：错误日志）
	private String logTitle;		// 日志标题
	private String logRemoteAddr; 	// 操作用户的IP地址
	private String logRequestUri; 	// 操作的URI
	private String logMethod; 		// 操作的方式
	private String logParams; 		// 操作提交的数据
	private String logUserAgent;	// 操作用户代理信息
	private String logException; 	// 异常信息
	
	
	private Date LogBeginDate;		// 开始日期
	private Date LogEndDate;		// 结束日期
	private String loginName;	// 登录名
	private Integer userUserId;     // 操作用户
	private String userName;		//用户名
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public String getLogTitle() {
		return logTitle;
	}
	public void setLogTitle(String logTitle) {
		this.logTitle = logTitle;
	}
	public String getLogRemoteAddr() {
		return logRemoteAddr;
	}
	public void setLogRemoteAddr(String logRemoteAddr) {
		this.logRemoteAddr = logRemoteAddr;
	}
	public String getLogRequestUri() {
		return logRequestUri;
	}
	public void setLogRequestUri(String logRequestUri) {
		this.logRequestUri = logRequestUri;
	}
	public String getLogMethod() {
		return logMethod;
	}
	public void setLogMethod(String logMethod) {
		this.logMethod = logMethod;
	}
	public String getLogParams() {
		return logParams;
	}
	public void setLogParams(String logParams) {
		this.logParams = logParams;
	}
	public String getLogUserAgent() {
		return logUserAgent;
	}
	public void setLogUserAgent(String logUserAgent) {
		this.logUserAgent = logUserAgent;
	}
	public String getLogException() {
		return logException;
	}
	public void setLogException(String logException) {
		this.logException = logException;
	}
	
	public Date getLogBeginDate() {
		return LogBeginDate;
	}
	public void setLogBeginDate(Date logBeginDate) {
		LogBeginDate = logBeginDate;
	}
	public Date getLogEndDate() {
		return LogEndDate;
	}
	public void setLogEndDate(Date logEndDate) {
		LogEndDate = logEndDate;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Integer getUserUserId() {
		return userUserId;
	}
	public void setUserUserId(Integer userUserId) {
		this.userUserId = userUserId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
