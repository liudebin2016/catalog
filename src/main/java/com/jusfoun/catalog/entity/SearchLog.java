package com.jusfoun.catalog.entity;

import java.util.Date;

import com.jusfoun.catalog.common.entity.DataEntity;

/**
 * 搜索日志
 * @author xuym
 *
 */
public class SearchLog extends DataEntity<SearchLog> {
	
	private static final long serialVersionUID = 1L;
	
	/******************搜索类型值--start********************************/
	public static final int TYPE_OFFICE = 1;//机构
	public static final int TYPE_JOB = 2;//岗位
	public static final int TYPE_BUSINESS = 3;//业务
	public static final int TYPE_RESOURCE = 4;//资源
	public static final int TYPE_SUBJECT = 5;//主题
	/******************搜索类型值--end**********************************/
	
	private String keyword;//搜索关键词
	private Date srhTime;//搜索日期
	private Integer srhType;//搜索类型	
	private Integer officeId;//机构id
	
	public Integer getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Date getSrhTime() {
		return srhTime;
	}
	public void setSrhTime(Date srhTime) {
		this.srhTime = srhTime;
	}
	public Integer getSrhType() {
		return srhType;
	}
	public void setSrhType(Integer srhType) {
		this.srhType = srhType;
	}
}
