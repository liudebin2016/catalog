package com.jusfoun.catalog.vo;

import java.util.List;

import com.jusfoun.catalog.common.entity.DataEntity;
import com.jusfoun.catalog.entity.User;

public class JobAndOfficeView extends DataEntity<JobAndOfficeView> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4851608712391093580L;
	private String jobName;//名称
    private String jobDuty;//职责
    private String jobType;//岗位属性
    private String jobStatus; //当前状态
    
    private Integer officeId;
	private String officeCode; 		// 机构编码
	private String officeName; 		// 机构名称
	private String officeDuty;        // 机构职责
	private Integer officeSort;		// 排序
	private String officeType; 		// 机构类型（1：公司；2：部门；3：小组）
	private String officeGrade; 		// 机构等级（1：一级；2：二级；3：三级；4：四级）
	private String officeAddress; 	// 联系地址
	private String officeZipCode; 	// 邮政编码
	private String officeMaster; 		// 负责人
	private String officePhone; 		// 电话
	private String officeFax; 		// 传真
	private String officeEmail; 		// 邮箱
	private String officeUseable;		//是否可用
	private User officePrimaryPerson;	//主负责人
	private User officeDeputyPerson;	//副负责人
	
	private Integer businessId;
	private String businessName;//业务名称
	
	private List<Integer> OfficeIds;  //目录树下点击一个节点 保存所有子节点id
	
	
	public List<Integer> getOfficeIds() {
		return OfficeIds;
	}
	public void setOfficeIds(List<Integer> officeIds) {
		OfficeIds = officeIds;
	}
	public Integer getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobDuty() {
		return jobDuty;
	}
	public void setJobDuty(String jobDuty) {
		this.jobDuty = jobDuty;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getOfficeDuty() {
		return officeDuty;
	}
	public void setOfficeDuty(String officeDuty) {
		this.officeDuty = officeDuty;
	}
	public Integer getOfficeSort() {
		return officeSort;
	}
	public void setOfficeSort(Integer officeSort) {
		this.officeSort = officeSort;
	}
	public String getOfficeType() {
		return officeType;
	}
	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}
	public String getOfficeGrade() {
		return officeGrade;
	}
	public void setOfficeGrade(String officeGrade) {
		this.officeGrade = officeGrade;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getOfficeZipCode() {
		return officeZipCode;
	}
	public void setOfficeZipCode(String officeZipCode) {
		this.officeZipCode = officeZipCode;
	}
	public String getOfficeMaster() {
		return officeMaster;
	}
	public void setOfficeMaster(String officeMaster) {
		this.officeMaster = officeMaster;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getOfficeFax() {
		return officeFax;
	}
	public void setOfficeFax(String officeFax) {
		this.officeFax = officeFax;
	}
	public String getOfficeEmail() {
		return officeEmail;
	}
	public void setOfficeEmail(String officeEmail) {
		this.officeEmail = officeEmail;
	}
	public String getOfficeUseable() {
		return officeUseable;
	}
	public void setOfficeUseable(String officeUseable) {
		this.officeUseable = officeUseable;
	}
	public User getOfficePrimaryPerson() {
		return officePrimaryPerson;
	}
	public void setOfficePrimaryPerson(User officePrimaryPerson) {
		this.officePrimaryPerson = officePrimaryPerson;
	}
	public User getOfficeDeputyPerson() {
		return officeDeputyPerson;
	}
	public void setOfficeDeputyPerson(User officeDeputyPerson) {
		this.officeDeputyPerson = officeDeputyPerson;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	
}
