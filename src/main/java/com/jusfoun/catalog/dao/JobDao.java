package com.jusfoun.catalog.dao;

import java.util.HashMap;
import java.util.List;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.entity.Job;
import com.jusfoun.catalog.vo.JobAndOfficeView;

/**
 * 岗位Dao
 * @author liudebin
 *
 */
@MyBatisDao
public interface JobDao extends CrudDao<Job>{

	public int createJob(Job job);

	public List<JobAndOfficeView> findJobList(Job job);

	public Job selectById(String id);

	public int updateById(Job job);

	public List findJobByCondition(HashMap<String, String> cMap);

	public int insertJobAndOffice(HashMap<String, Object> cMap);
	/**
	 * 查询机构下关联的岗位
	 * @param officeId 机构id
	 */
	public List<Job> findJobsByOfficeId(Integer officeId);

	public int findListCount(Job job);

	public int deleteById(Job job);

	public int findListCountByOfficeId(JobAndOfficeView job);

	public List<JobAndOfficeView> findJobListByOfficeId(JobAndOfficeView job);

	public int insertJob_business(HashMap<String, Object> cMap);

	public int updateJob_Office(HashMap<String, Object> cMap);

	public int updateJob_business(HashMap<String, Object> cMap);

	public int deleteJob_Office(Job job);

	public int deleteJob_Bussiness(Job job);

}