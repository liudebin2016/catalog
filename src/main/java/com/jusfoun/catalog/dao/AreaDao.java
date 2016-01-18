package com.jusfoun.catalog.dao;

import com.jusfoun.catalog.common.dao.TreeDao;
import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.entity.Area;

/**
 * 区域DAO接口
 * @author Connor
 * @version 2015-12-18
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {

	/**查询有效个数
	 * @return
	 */
	Long getCount();
	
}
