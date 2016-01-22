package com.jusfoun.catalog.dao;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 根据主题Id获取资源数量
	 * @param sqlMap
	 * @return
	 */
	int findListCountBySubId(Map<String, Object> sqlMap);
	
	/**
	 * 根据主题Id获取资源
	 * @param sqlMap
	 * @return
	 */
	List<ResourceInfo> findListBySubId(Map<String, Object> sqlMap);
	
	/**
	 * 根据业务Id获取资源数量
	 * @param sqlMap
	 * @return
	 */
	int findListCountByBizId(Map<String, Object> sqlMap);

	/**
	 * 根据业务Id获取资源
	 * @param sqlMap
	 * @return
	 */
	List<ResourceInfo> findListByBizId(Map<String, Object> sqlMap);

	/**查询有效个数
	 * @return
	 */
	Long getCount();

	List<ResourceInfo> findSrhList(ResourceInfo rsc);

	int findSrhListCount(ResourceInfo rsc);
}