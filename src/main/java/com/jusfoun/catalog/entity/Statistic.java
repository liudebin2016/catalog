package com.jusfoun.catalog.entity;

import java.io.Serializable;

/**
 * 统计Entity
 * @author liudebin
 *
 */
public class Statistic implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String region;//区域
	private String office;//机构
	private String ofcDuty;//机构职责
	private int jobCount;//岗位数量
	private int bizCount;//业务数量
	private int rscCount;//资源数量
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getOfcDuty() {
		return ofcDuty;
	}
	public void setOfcDuty(String ofcDuty) {
		this.ofcDuty = ofcDuty;
	}
	public int getJobCount() {
		return jobCount;
	}
	public void setJobCount(int jobCount) {
		this.jobCount = jobCount;
	}
	public int getBizCount() {
		return bizCount;
	}
	public void setBizCount(int bizCount) {
		this.bizCount = bizCount;
	}
	public int getRscCount() {
		return rscCount;
	}
	public void setRscCount(int rscCount) {
		this.rscCount = rscCount;
	}
}
