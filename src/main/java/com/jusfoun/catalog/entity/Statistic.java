package com.jusfoun.catalog.entity;

import java.io.Serializable;

/**
 * 统计Entity
 * @author liudebin
 *
 */
public class Statistic implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String demain;//区域
	private String officeName;//机构
	private String duty;//机构职责
	private String status;//机构注册状态
	private int jCount;//岗位数量
	private int bCount;//业务数量
	private int rCount;//资源数量
	
	public String getDemain() {
		return demain;
	}
	public void setDemain(String demain) {
		this.demain = demain;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getjCount() {
		return jCount;
	}
	public void setjCount(int jCount) {
		this.jCount = jCount;
	}
	public int getbCount() {
		return bCount;
	}
	public void setbCount(int bCount) {
		this.bCount = bCount;
	}
	public int getrCount() {
		return rCount;
	}
	public void setrCount(int rCount) {
		this.rCount = rCount;
	}
	
}
