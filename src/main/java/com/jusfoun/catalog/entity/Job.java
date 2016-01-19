package com.jusfoun.catalog.entity;

import com.jusfoun.catalog.common.entity.DataEntity;

/**
 * 岗位Entity
 * @author liudebin
 *
 */
public class Job extends DataEntity<Job>{

	private static final long serialVersionUID = 1L;
	
	private String name;//名称
    private String duty;//职责
    private String type;//岗位属性
    private String status; //当前状态
    private Integer officeId;
    
    public Integer getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}