package com.jusfoun.catalog.dao;

import java.util.List;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.entity.ResourceInfo;
import com.jusfoun.catalog.entity.SubjectInfo;

/**
 * 资源Dao
 * @author liudebin
 *
 */
@MyBatisDao
public interface ResourceInfoDao extends CrudDao<ResourceInfo>{

	/**
	 * 获取机构下的资源目录
	 * @param subjectInfo
	 * @return
	 */
	List<SubjectInfo> findRscClList(ResourceInfo subjectInfo);

	int findListCount();
	
	/**根据机构d查询对应的业务
	 * @param officeId 机构id
	 * @return
	 */
	List<ResourceInfo> findResourceByOfficeId(Integer officeId);
}