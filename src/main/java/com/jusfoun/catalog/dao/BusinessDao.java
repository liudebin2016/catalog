package com.jusfoun.catalog.dao;

import java.util.List;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.entity.Business;

/**
 * 业务Dao
 * @author liudebin
 *
 */
@MyBatisDao
public interface BusinessDao extends CrudDao<Business> {

	/**根据机构d查询对应的业务
	 * @param officeId 机构id
	 * @return
	 */
	List<Business> findBusinessByOfficeId(Integer officeId);
	
	/**
	 * 查询列表中的个数
	 * @param biz
	 * @return
	 */
	int findListCount(Business biz);

}