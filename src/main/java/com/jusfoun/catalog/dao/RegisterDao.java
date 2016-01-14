package com.jusfoun.catalog.dao;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.entity.Register;

@MyBatisDao
public interface RegisterDao extends CrudDao<Register> {

	int findListCount(Register register);

	/**审批
	 * @param register
	 */
	void approve(Register register);

}
