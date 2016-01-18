package com.jusfoun.catalog.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sound.sampled.SourceDataLine;

import org.apache.shiro.mgt.SubjectDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.BaseService;
import com.jusfoun.catalog.dao.AreaDao;
import com.jusfoun.catalog.dao.BusinessDao;
import com.jusfoun.catalog.dao.JobDao;
import com.jusfoun.catalog.dao.OfficeDao;
import com.jusfoun.catalog.dao.ResourceInfoDao;
import com.jusfoun.catalog.dao.SubjectInfoDao;

@Service
@Transactional(readOnly=true)
public class StatisticService extends BaseService {

	@Resource
	private AreaDao areaDao;
	@Resource
	private OfficeDao officeDao;
	@Resource
	private JobDao jobDao;
	@Resource
	private BusinessDao businessDao;
	@Resource
	private ResourceInfoDao resourceInfoDao;
	@Resource
	private SubjectInfoDao subjectInfoDao;
	/**查询各个模块的总量
	 * @return
	 */
	public Map<String, String> getAllModuleCount() {
		Long areaCount = areaDao.getCount();
		Long officeCount = officeDao.getCount();
		Long jobCount = jobDao.getCount();
		Long businessCount = businessDao.getCount();
		Long resourceCount = resourceInfoDao.getCount();
		Long subjectCount = subjectInfoDao.getCount();
		Map<String, String> result = new HashMap<String, String>();
		DecimalFormat format = new DecimalFormat("#,##0");
		
		result.put("area", areaCount == null ? "0" : format.format(areaCount));
		result.put("office", officeCount == null ? "0" : format.format(officeCount));
		result.put("job", jobCount == null ? "0" : format.format(jobCount));
		result.put("business", businessCount == null ? "0" : format.format(businessCount));
		result.put("resource", resourceCount == null ? "0" : format.format(resourceCount));
		result.put("subject", subjectCount == null ? "0" : format.format(subjectCount));
		return result;
	}
	
}