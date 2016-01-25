package com.jusfoun.catalog.dao;

import java.util.List;
import java.util.Map;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.entity.ResourceInfo;
import com.jusfoun.catalog.entity.SubjectInfo;

/**
 * 主题接口
 * @author liudebin
 *
 */
@MyBatisDao
public interface SubjectInfoDao  extends CrudDao<SubjectInfo> {

	/**
	 * 根据业务Id查询主题数量
	 * @param sqlMap
	 * @return
	 */
	int findListCountByBizId(Map<String, Object> sqlMap);

	/**
	 * 根据业务id查询主题
	 * @param sqlMap
	 * @return
	 */
	List<ResourceInfo> findListByBizId(Map<String, Object> sqlMap);

	/**
	 * 根据资源Id查询主题数量
	 * @param sqlMap
	 * @return
	 */
	int findListCountByRscId(Map<String, Object> sqlMap);

	/**
	 * 根据资源id查询主题
	 * @param sqlMap
	 * @return
	 */
	List<ResourceInfo> findListByRscId(Map<String, Object> sqlMap);

	/**查询有效个数
	 * @return
	 */
	Long getCount();

	/**
	 * 前端搜索使用
	 * @param sub
	 * @return
	 */
	List<ResourceInfo> findSrhList(SubjectInfo sub);

	/**
	 * 前端搜索使用
	 * @param sub
	 * @return
	 */
	int findSrhListCount(SubjectInfo sub);

	void findListCount(SubjectInfo si);

}