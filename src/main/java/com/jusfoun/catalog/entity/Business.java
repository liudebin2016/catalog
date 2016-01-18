package com.jusfoun.catalog.entity;

import java.util.Date;

import com.jusfoun.catalog.common.entity.DataEntity;

/**
 * 业务Entity
 * @author liudebin
 *
 */
public class Business extends DataEntity<Business>{
	
	private static final long serialVersionUID = 1L;
	
    private String name;//业务名称
    private String nameRef;//业务事项名称填写依据
    private String firstName;//一级子项名称
    private String secondName;//二级子项名称
    private String thirdName;//三级子项名称
    private String code;//业务事项编码
    private String type;//业务事项分类
    private String basis;//业务事项办理依据
    private String flow;//业务事项办理流程
    private String summary;//业务事项简述
    private String timeLimit;//总时限
    private String chargeBasis;//收费依据
    private Long chargeOfficeId;//业务事项主管单位
    private Long implOfficeId;//业务事项实施单位
    private String workload;//业务量/工作量
    private String relateOffice;//业务事项办理涉及的其他相关单位
    private String needData;//业务事项所需材料
    private String produceData;//业务事项产生材料
    private String isUse;//业务事项应用系统
    private String shareWith;//资源共享范围
    private String status;//业务状态：0-未注册，1-注册中，2-已注册，3-未通过，4-删除中
    private Integer subjectId;//所属主题分类
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameRef() {
        return nameRef;
    }

    public void setNameRef(String nameRef) {
        this.nameRef = nameRef;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getChargeBasis() {
        return chargeBasis;
    }

    public void setChargeBasis(String chargeBasis) {
        this.chargeBasis = chargeBasis;
    }

    public Long getChargeOfficeId() {
        return chargeOfficeId;
    }

    public void setChargeOfficeId(Long chargeOfficeId) {
        this.chargeOfficeId = chargeOfficeId;
    }

    public Long getImplOfficeId() {
        return implOfficeId;
    }

    public void setImplOfficeId(Long implOfficeId) {
        this.implOfficeId = implOfficeId;
    }

    public String getWorkload() {
        return workload;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }

    public String getRelateOffice() {
        return relateOffice;
    }

    public void setRelateOffice(String relateOffice) {
        this.relateOffice = relateOffice;
    }

    public String getNeedData() {
        return needData;
    }

    public void setNeedData(String needData) {
        this.needData = needData;
    }

    public String getProduceData() {
        return produceData;
    }

    public void setProduceData(String produceData) {
        this.produceData = produceData;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }

    public String getShareWith() {
        return shareWith;
    }

    public void setShareWith(String shareWith) {
        this.shareWith = shareWith;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

}