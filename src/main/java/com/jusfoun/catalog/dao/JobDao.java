package com.jusfoun.catalog.dao;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.entity.Job;

/**
 * 岗位Dao
 * @author liudebin
 *
 */
@MyBatisDao
public interface JobDao extends CrudDao<Job>{

}