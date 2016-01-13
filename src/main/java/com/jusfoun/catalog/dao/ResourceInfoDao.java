package com.jusfoun.catalog.dao;

import java.util.List;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.entity.ResourceInfo;

/**
 * 资源Dao
 * @author liudebin
 *
 */
@MyBatisDao
public interface ResourceInfoDao extends CrudDao<ResourceInfo>{

	/**根据机构d查询对应的业务
	 * @param officeId 机构id
	 * @return
	 */
	List<ResourceInfo> findResourceByOfficeId(Integer officeId);

	/**
	 * 查询列表总数
	 * @param rsc
	 * @return
	 */
	int findListCount(ResourceInfo rsc);
}