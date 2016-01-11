package com.jusfoun.catalog.service;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.JobDao;
import com.jusfoun.catalog.entity.Job;
@Service
@Transactional(readOnly = false)
public class JobService extends CrudService<JobDao,Job> {

	
	public int createJob(Job job,String officeId){
		int i = dao.createJob(job);
		//插入office表
		HashMap<String, Object> cMap = new HashMap<String, Object>();
		cMap.put("officeId", officeId);
		cMap.put("jobId", job.getId());
		return dao.insertJobAndOffice(cMap);
	}

	public List<Job> findJobList(HashMap<String, String> cMap){
		
		return dao.findJobList(cMap);
	}

	public Job selectById(String id){
		
		return dao.selectById(id);
	}

	public boolean updateById(Job job) {
		int index = dao.updateById(job);
		return index>0?true:false;
	}

	public List findJobByCondition(HashMap<String, String> cMap) {
		
		return dao.findJobByCondition(cMap);
	}

}
