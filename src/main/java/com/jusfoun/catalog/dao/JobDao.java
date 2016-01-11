package com.jusfoun.catalog.dao;

import java.util.HashMap;
import java.util.List;

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

	public int createJob(Job job);

	public List<Job> findJobList(HashMap<String, String> cMap);

	public Job selectById(String id);

	public int updateById(Job job);

	public List findJobByCondition(HashMap<String, String> cMap);

	public int insertJobAndOffice(HashMap<String, Object> cMap);

}