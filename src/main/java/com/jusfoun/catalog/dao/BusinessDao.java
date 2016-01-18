package com.jusfoun.catalog.dao;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 根据主题Id获取业务数量
	 * @param sqlMap
	 * @return
	 */
	int findListCountBySubId(Map<String, Object> sqlMap);
	
	/**
	 * 根据主题Id获取业务
	 * @param sqlMap
	 * @return
	 */
	List<Business> findListBySubId(Map<String, Object> sqlMap);

	/**
	 * 根据资源Id获取业务数量
	 * @param sqlMap
	 * @return
	 */
	int findListCountByRscId(Map<String, Object> sqlMap);

	/**
	 * 根据资源Id获取业务
	 * @param sqlMap
	 * @return
	 */
	List<Business> findListByRscId(Map<String, Object> sqlMap);

	/**查询有效个数
	 * @return
	 */
	Long getCount();

}