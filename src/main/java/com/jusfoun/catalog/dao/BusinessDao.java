package com.jusfoun.catalog.dao;

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

}