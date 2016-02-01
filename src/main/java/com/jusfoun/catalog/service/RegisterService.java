package com.jusfoun.catalog.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.entity.DataEntity;
import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.BusinessDao;
import com.jusfoun.catalog.dao.JobDao;
import com.jusfoun.catalog.dao.OfficeDao;
import com.jusfoun.catalog.dao.RegisterDao;
import com.jusfoun.catalog.dao.ResourceInfoDao;
import com.jusfoun.catalog.dao.SubjectInfoDao;
import com.jusfoun.catalog.entity.Business;
import com.jusfoun.catalog.entity.Job;
import com.jusfoun.catalog.entity.Office;
import com.jusfoun.catalog.entity.Register;
import com.jusfoun.catalog.entity.ResourceInfo;
import com.jusfoun.catalog.utils.UserUtils;

@Service
@Transactional(readOnly=true)
public class RegisterService extends CrudService<RegisterDao, Register> {

	@Resource
	private BusinessDao businessDao;
	
	@Resource
	private JobDao jobDao;
	
	@Resource
	private OfficeDao officeDao;
	
	@Resource
	private ResourceInfoDao resourceInfoDao;
	
	@Resource
	private SubjectInfoDao subjectInfoDao;
	/**申请注册
	 * @param applyId 申请注册的id
	 * @param applyType 申请注册的类型
	 */
	@Transactional(readOnly=false)
	public void apply(Integer applyId, Integer applyType) {
		String applyName = "";
		if(applyType.intValue() == Register.TYPE_BUSINESS){
			Business business = businessDao.get(applyId);
			applyName = business.getName();
		}else if(applyType.intValue() == Register.TYPE_JOB){
			Job job = jobDao.selectById(applyId.toString());
			applyName = job.getName();
		}else if(applyType.intValue() == Register.TYPE_OFFICE){
			Office office = officeDao.get(applyId);
			applyName = office.getName();
		}else if(applyType.intValue() == Register.TYPE_RESOURCE){
			ResourceInfo resourceInfo = resourceInfoDao.get(applyId);
			applyName = resourceInfo.getName();
		}
		Register register = new Register();
		register.setOffice(UserUtils.getUser().getOffice());
		register.setApplyType(applyType);
		register.setApplyId(applyId);
		register.setApplyName(applyName);
		register.setApplyBy(UserUtils.getUser());
		register.setApplyDate(new Date());
		register.setApplyFlag(Register.STATUS_REGISTER);
		register.setApproveFlag(Register.STATUS_APPROVALING);
		dao.insert(register);
	}
	
	/**申请注销
	 * @param applyId 申请注销的id
	 * @param applyType 申请注销的类型
	 */
	@Transactional(readOnly=false)
	public void cancel(Integer cancelId, Integer cancelType) {
		String applyName = "";
		if(cancelType.intValue() == Register.TYPE_BUSINESS){
			Business business = businessDao.get(cancelId);
			applyName = business.getName();
		}else if(cancelType.intValue() == Register.TYPE_JOB){
			Job job = jobDao.selectById(cancelId.toString());
			applyName = job.getName();
		}else if(cancelType.intValue() == Register.TYPE_OFFICE){
			Office office = officeDao.get(cancelId);
			applyName = office.getName();
		}else if(cancelType.intValue() == Register.TYPE_RESOURCE){
			ResourceInfo resourceInfo = resourceInfoDao.get(cancelId);
			applyName = resourceInfo.getName();
		}
		Register register = new Register();
		register.setOffice(UserUtils.getUser().getOffice());
		register.setApplyType(cancelType);
		register.setApplyId(cancelId);
		register.setApplyName(applyName);
		register.setApplyBy(UserUtils.getUser());
		register.setApplyDate(new Date());
		register.setApplyFlag(Register.STATUS_CANCEL);
		register.setApproveFlag(Register.STATUS_APPROVALING);
		dao.insert(register);
	}

	public int findListCount(Register register) {
		return dao.findListCount(register);
	}

	/**审批
	 * @param id 主键
	 * @param approveFlag 审批意见（0：通过，1：不通过）
	 */
	@Transactional(readOnly=false)
	public void approve(Integer id, String approveFlag) {
		Register register = new Register();
		register.setId(id);
		register.setApproveFlag(approveFlag);
		register.setApproveBy(UserUtils.getUser());
		register.setApproveDate(new Date());
		dao.approve(register);
		
		//更新模块主表del_flag值
		register = dao.get(id);
		String applyFlag = register.getApplyFlag();
		String resultFlag = "";
		if(Register.STATUS_UNAPPROVAL.equals(approveFlag)){
			resultFlag = Register.STATUS_REGISTER.equals(applyFlag) ? DataEntity.STATUS_UNAPPLY : DataEntity.STATUS_APPLYED;
		}else{
			resultFlag = Register.STATUS_REGISTER.equals(applyFlag) ? DataEntity.STATUS_APPLYED : DataEntity.STATUS_CANCELLED;
		}
		switch (register.getApplyType().intValue()) {
			case Register.TYPE_BUSINESS:
				Business bus = new Business();
				bus.setId(register.getApplyId());
				bus.setStatus(resultFlag);
				businessDao.update(bus);
				break;
			case Register.TYPE_JOB:
				Job job = new Job();
				job.setId(register.getApplyId());
				job.setStatus(resultFlag);
				jobDao.updateById(job);
				break;
			case Register.TYPE_OFFICE:
				Office office = new Office();
				office.setId(register.getApplyId());
				office.setStatus(resultFlag);
				officeDao.update(office);
				break;
			case Register.TYPE_RESOURCE:
				ResourceInfo res = new ResourceInfo();
				res.setId(register.getApplyId());
				res.setStatus(resultFlag);
				resourceInfoDao.update(res);
				break;
		}
	}
}