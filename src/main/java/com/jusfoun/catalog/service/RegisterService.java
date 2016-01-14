package com.jusfoun.catalog.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.RegisterDao;
import com.jusfoun.catalog.entity.Register;
import com.jusfoun.catalog.utils.UserUtils;

@Service
@Transactional(readOnly=true)
public class RegisterService extends CrudService<RegisterDao, Register> {

	/**申请注册
	 * @param applyId 申请注册的id
	 * @param applyType 申请注册的类型
	 */
	@Transactional(readOnly=false)
	public void apply(Integer applyId, Integer applyType) {
		Register register = new Register();
		register.setOffice(UserUtils.getUser().getOffice());
		register.setApplyType(applyType);
		register.setApplyId(applyId);
		register.setApplyBy(UserUtils.getUser());
		register.setApplyDate(new Date());
		register.setApplyFlag(Register.STATUS_REGISTER);
		register.setApproveFlag(Register.STATUS_APPROVALING);
		dao.insert(register);
	}

	public int findListCount(Register register) {
		return dao.findListCount(register);
	}

	/**审批
	 * @param applyId 信息id
	 * @param applyType 信息类型
	 * @param statusApproved 审批意见（通过，不通过）
	 */
	@Transactional(readOnly=false)
	public void approve(Integer applyId, Integer applyType, String statusApproved) {
		Register register = new Register();
		register.setApplyId(applyId);
		register.setApplyType(applyType); 
		register.setApproveFlag(statusApproved);
		register.setApproveBy(UserUtils.getUser());
		register.setApproveDate(new Date());
		dao.approve(register);
	}
}