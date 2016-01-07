package com.jusfoun.catalog.entity;

import java.util.Date;

import com.jusfoun.catalog.common.entity.DataEntity;

/**
 * 目录Entity
 * @author liudebin
 *
 */
public class CatalogInfo extends DataEntity<CatalogInfo>{
    
	private static final long serialVersionUID = 1L;
	
	private Integer type;//目录类型
    private String typeValue;//类型值
    private Integer officeId;//机构Id

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}