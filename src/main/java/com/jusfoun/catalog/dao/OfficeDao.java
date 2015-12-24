package com.jusfoun.catalog.dao;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.common.dao.TreeDao;
import com.jusfoun.catalog.entity.Office;


/**
 * 机构DAO接口
 * @author Connor
 * @version 2015-12-18
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
}
