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

	public int findListCount(Job job);

	public int deleteById(Job job);

	public int findListCountByOfficeId(JobAndOfficeView job);

	public List<JobAndOfficeView> findJobListByOfficeId(JobAndOfficeView job);

	public int insertJob_business(HashMap<String, Object> cMap);

	public int updateJob_business(HashMap<String, Object> cMap);

	public int deleteJob_Office(Job job);

	public int deleteJob_Bussiness(Job job);
	
	/**查询有效个数
	 * @return
	 */
	public Long getCount();

	/**
	 * 前端搜索用
	 * @param job
	 * @return
	 */
	public int findSrhListCount(Job job);

	/**
	 * 前端搜索用
	 * @param job
	 * @return
	 */
	public List<Job> findSrhList(Job job);
	/**
	 * 获得该job所拥有的所有业务
	 * @param id
	 * @return
	 */
	public String selectBusinessIdByJobId(String id);

	/**
	 * 获得该job所拥有的所有业务名字
	 * @param id
	 * @return
	 */
	public List<JobAndOfficeView> selectBusinessNaByJobId(String id);
	/**
	 * 根据列获得所有的job
	 * @param id
	 * @return
	 */
	public List<Job> findJobsByOfficeId(Integer officeId);

	/**
	 * 检查名字
	 * @param id
	 * @return
	 */
	public int checkjobName(Job job);

}