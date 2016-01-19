package com.jusfoun.catalog.entity;

import java.util.Date;

import com.jusfoun.catalog.common.entity.DataEntity;

/**搜索日志
 * @author xuym
 *
 */
public class SearchLog extends DataEntity<SearchLog> {
	
	private static final long serialVersionUID = 1L;
	
	public static final int TYPE_OFFICE = 1;
	public static final int TYPE_JOB = 2;
	public static final int TYPE_BUSINESS = 3;
	public static final int TYPE_RESOURCE = 4;
	public static final int TYPE_SUBJECT = 5;
	
	/**
	 * 搜索关键词
	 */
	private String keyword;
	/**
	 * 搜索日期
	 */
	private Date srhTime;
	/**
	 * 搜索类型
	 */
	private Integer srhType;
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
