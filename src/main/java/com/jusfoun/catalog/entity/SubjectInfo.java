package com.jusfoun.catalog.entity;

import com.jusfoun.catalog.common.entity.DataEntity;

/**
 * 主题Entity
 * @author liudebin
 *
 */
public class SubjectInfo extends DataEntity<SubjectInfo>{
	
	private static final long serialVersionUID = 1L;
	
	private String name;//主题名称
    private Integer parentId;//父主题ID
    private String parentName;//父主题名称
    private String descr;//主题描述
    private String shareRegion;//共享范围
    private String shareMode;//共享方式
    private Integer status;//主题状态

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getShareRegion() {
        return shareRegion;
    }

    public void setShareRegion(String shareRegion) {
        this.shareRegion = shareRegion;
    }

    public String getShareMode() {
        return shareMode;
    }

    public void setShareMode(String shareMode) {
        this.shareMode = shareMode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}