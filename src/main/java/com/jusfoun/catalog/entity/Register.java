package com.jusfoun.catalog.entity;

import java.util.Date;

import com.jusfoun.catalog.common.entity.DataEntity;

/**注册申请、注册审批
 * @author xuym
 *
 */
public class Register extends DataEntity<Register> {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请注册
	 */
	public static final String STATUS_REGISTER = "1";
	/**
	 * 申请注销
	 */
	public static final String STATUS_CANCEL = "2";
	/**
	 * 待处理
	 */
	public static final String STATUS_APPROVALING = "0";
	/**
	 * 通过
	 */
	public static final String STATUS_APPROVED = "1";
	/**
	 * 未通过
	 */
	public static final String STATUS_UNAPPROVAL = "2";
	
	/**
	 * 机构职责
	 */
	public static final int TYPE_OFFICE = 1;
	/**
	 * 部门岗位
	 */
	public static final int TYPE_JOB = 2;
	/**
	 * 业务信息
	 */
	public static final int TYPE_BUSINESS = 3;
	/**
	 * 资源信息
	 */
	public static final int TYPE_RESOURCE = 4;
	
	private Office office; // 归属部门
	private Integer applyType; // 信息类型
	private Integer applyId; // 信息id
	private String applyName; // 信息名称
	private User applyBy;	// 申请者
	private Date applyDate;	// 申请日期
	private User approveBy;	// 审批者
	private Date approveDate;	// 审批日期
	private String applyFlag; // 申请状态
	private String approveFlag; // 审批状态
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	public Integer getApplyType() {
		return applyType;
	}
	public void setApplyType(Integer applyType) {
		this.applyType = applyType;
	}
	public Integer getApplyId() {
		return applyId;
	}
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public User getApplyBy() {
		return applyBy;
	}
	public void setApplyBy(User applyBy) {
		this.applyBy = applyBy;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public User getApproveBy() {
		return approveBy;
	}
	public void setApproveBy(User approveBy) {
		this.approveBy = approveBy;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public String getApplyFlag() {
		return applyFlag;
	}
	public void setApplyFlag(String applyFlag) {
		this.applyFlag = applyFlag;
	}
	public String getApproveFlag() {
		return approveFlag;
	}
	public void setApproveFlag(String approveFlag) {
		this.approveFlag = approveFlag;
	}
}
