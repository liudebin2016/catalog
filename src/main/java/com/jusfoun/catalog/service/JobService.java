package com.jusfoun.catalog.service;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.JobDao;
import com.jusfoun.catalog.entity.Job;
import com.jusfoun.catalog.vo.JobAndOfficeView;
@Service
@Transactional(readOnly = false)
public class JobService extends CrudService<JobDao,Job> {

	
	public int createJob(Job job,String officeId, String businessId){
		int i = dao.createJob(job);
		//插入job_office表
		HashMap<String, Object> cMap = new HashMap<String, Object>();
		cMap.put("officeId", officeId);
		cMap.put("jobId", job.getId());
		cMap.put("businessId", businessId);
		return dao.insertJob_business(cMap);
	}

	public List<JobAndOfficeView> findJobList(Job job){
		
		return dao.findJobList(job);
	}

	public Job selectById(String id){
		
		return dao.selectById(id);
	}

	public boolean updateById(Job job, HashMap<String, Object> cMap) {
		int index = dao.updateById(job);
		dao.updateJob_business(cMap);
		return index>0?true:false;
	}

	public List findJobByCondition(HashMap<String, String> cMap) {
		
		return dao.findJobByCondition(cMap);
	}

	public int findListCount(Job job) {
		
		return dao.findListCount(job);
	}

	public int deleteById(Job job) {
		dao.deleteJob_Bussiness(job);
		return dao.deleteById(job);
	}

	public int findListCountByOfficeId(JobAndOfficeView job) {
		
		return dao.findListCountByOfficeId(job);
	}

	public List<JobAndOfficeView> findJobListByOfficeId(JobAndOfficeView job) {
		
		return dao.findJobListByOfficeId(job);
	}
}
