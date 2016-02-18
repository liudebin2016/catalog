package com.jusfoun.catalog.service;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.entity.DataEntity;
import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.JobDao;
import com.jusfoun.catalog.entity.Job;
import com.jusfoun.catalog.vo.JobAndOfficeView;
@Service
@Transactional(readOnly = false)
public class JobService extends CrudService<JobDao,Job> {

	
	public int createJob(Job job,String officeId, String[] businessId){
		int index = dao.createJob(job);
		//插入job_office表
		HashMap<String, Object> cMap = new HashMap<String, Object>();
		for(int i=0;i<businessId.length;i++){
			cMap.put("businessId", Integer.parseInt(businessId[i]));
			cMap.put("jobId", job.getId());
			dao.insertJob_business(cMap);
		}
		return index;
	}

	public List<JobAndOfficeView> findJobList(Job job){
		
		return dao.findJobList(job);
	}

	public Job selectById(String id){
		
		return dao.selectById(id);
	}

	public boolean updateById(Job job, HashMap<String, Object> cMap) {
		int index = dao.updateById(job);
		dao.deleteJob_Bussiness(job);
		String[] business = (String[]) cMap.get("businessId");
		for(int i=0;i<business.length;i++){
			cMap.put("businessId", Integer.parseInt(business[i]));
			cMap.put("jobId", job.getId());
			dao.insertJob_business(cMap);
		}
//		dao.insertJob_business(cMap);
		return index>0?true:false;
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

	public int jobApplyFor(String ids) {
		String[] row = ids.split(",");
		for(int i=0;i<row.length;i++){
			Job job = new Job();
			job.setId(Integer.parseInt(row[i]));
			job.setStatus(DataEntity.STATUS_APPLYING);
			dao.updateById(job);
		}
		return 0;
	}

	public int jobLogOff(String ids) {
		String[] row = ids.split(",");
		int index = 0;
		for(int i=0;i<row.length;i++){
			Job job = new Job();
			job.setId(Integer.parseInt(row[i]));
			job.setStatus(DataEntity.STATUS_CANCELLING);
			dao.updateById(job);
			index++;
		}
		return index;
	}

	/**
	 * 前端搜索用
	 * @param job
	 * @return
	 */
	public int findSrhListCount(Job job) {
		return dao.findSrhListCount(job);
	}

	/**
	 * 前端搜索用
	 * @param job
	 * @return
	 */
	public List<Job> findSrhList(Job job) {
		return dao.findSrhList(job);
	}

	public String selectBusinessIdByJobId(String id) {
		return dao.selectBusinessIdByJobId(id);
	}
	public String selectBusinessNaByJobId(String id) {
		return dao.selectBusinessNaByJobId(id);
	}

	public List<Job> findJobsByOfficeId(Integer officeId) {
		
		return dao.findJobsByOfficeId(officeId);
	}
}