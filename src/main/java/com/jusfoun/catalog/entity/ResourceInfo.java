package com.jusfoun.catalog.entity;

import java.util.Date;

/**
 * 资源Entity
 * @author liudebin
 *
 */
public class ResourceInfo {
   
    private Integer id;//
    private String name;//
    private Integer ofBusiness;//
    private Integer type;//
    private String code;//
    private String responseParty;//
    private Integer responseAttr;//
    private String responseCu;//
    private Integer collectWay;//
    private Integer securityLevel;//
    private String infoField;//
    private Integer isDbSupport;//
    private String remark;//
    private String shareRegion;//
    private String shareMode;//
    private Date createDate;//
    private Integer createBy;//
    private Date updateDate;//
    private Integer updateBy;//
    private String updateCycle;//
    private String descr;//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOfBusiness() {
        return ofBusiness;
    }

    public void setOfBusiness(Integer ofBusiness) {
        this.ofBusiness = ofBusiness;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResponseParty() {
        return responseParty;
    }

    public void setResponseParty(String responseParty) {
        this.responseParty = responseParty;
    }

    public Integer getResponseAttr() {
        return responseAttr;
    }

    public void setResponseAttr(Integer responseAttr) {
        this.responseAttr = responseAttr;
    }

    public String getResponseCu() {
        return responseCu;
    }

    public void setResponseCu(String responseCu) {
        this.responseCu = responseCu;
    }

    public Integer getCollectWay() {
        return collectWay;
    }

    public void setCollectWay(Integer collectWay) {
        this.collectWay = collectWay;
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getInfoField() {
        return infoField;
    }

    public void setInfoField(String infoField) {
        this.infoField = infoField;
    }

    public Integer getIsDbSupport() {
        return isDbSupport;
    }

    public void setIsDbSupport(Integer isDbSupport) {
        this.isDbSupport = isDbSupport;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateCycle() {
        return updateCycle;
    }

    public void setUpdateCycle(String updateCycle) {
        this.updateCycle = updateCycle;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}