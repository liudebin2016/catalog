package com.jusfoun.catalog.service;
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

	
	public int createJob(Job job){
		int i = dao.createJob(job);
		return i;
	}

	public List<Job> findJobList(){
		
		return dao.findJobList();
	}

	public Job selectById(String id){
		
		return dao.selectById(id);
	}

	public boolean updateById(Job job) {
		int index = dao.updateById(job);
		return index>0?true:false;
	}

	public List<Job> getJobSearch(Job job) {
		
		return dao.getJobSearch(job);
	}

}
