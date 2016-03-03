package com.jusfoun.catalog.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.BaseService;
import com.jusfoun.catalog.dao.BusinessDao;
import com.jusfoun.catalog.dao.JobDao;
import com.jusfoun.catalog.dao.OfficeDao;
import com.jusfoun.catalog.dao.ResourceInfoDao;
import com.jusfoun.catalog.dao.StatisticDao;
import com.jusfoun.catalog.dao.SubjectInfoDao;
import com.jusfoun.catalog.entity.IntegrStic;
import com.jusfoun.catalog.entity.Statistic;
import com.jusfoun.catalog.vo.SearchAnalysis;

@Service
@Transactional(readOnly=true)
public class StatisticService extends BaseService {

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
	@Resource
	private StatisticDao statisticDao;
	
	/**查询各个模块的总量
	 * @return
	 */
	public Map<String, String> getAllModuleCount() {
		Long areaCount = officeDao.getDemainCount();
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

	public int findListCount() {
		return statisticDao.findListCount();
	}

	public List<Statistic> findList(Map<String, Integer> paraMaps) {
		return statisticDao.findList(paraMaps);
	}
	
	public String integrStic(List<String> strs,List<String> times){
		List<IntegrStic> isList=statisticDao.integrStic();
		Map<String,String[]> sdf=new HashMap<String,String[]>();
		for(String str:strs){
			String[] dsd=null;
	    	for(IntegrStic is:isList){
				if(str.equals(String.valueOf(is.getType()))){
					if(is.getType()==1){
		    			if(sdf.containsKey("机构")){
		    				dsd=sdf.get("机构");
		    			}else{
		    				dsd=new String[times.size()];
		    				sdf.put("机构", dsd);
		    			}
		    		}else if(is.getType()==2){
		    			if(sdf.containsKey("岗位")){
		    				dsd=sdf.get("岗位");
		    			}else{
		    				dsd=new String[times.size()];
		    				sdf.put("岗位", dsd);
		    			}
		    		}else if(is.getType()==3){
		    			if(sdf.containsKey("业务")){
		    				dsd=sdf.get("业务");
		    			}else{
		    				dsd=new String[times.size()];
		    				sdf.put("业务", dsd);
		    			}
		    		}else if(is.getType()==4){
		    			if(sdf.containsKey("资源")){
		    				dsd=sdf.get("资源");
		    			}else{
		    				dsd=new String[times.size()];
		    				sdf.put("资源", dsd);
		    			}
		    		}else if(is.getType()==5){
		    			if(sdf.containsKey("主题")){
		    				dsd=sdf.get("主题");
		    			}else{
		    				dsd=new String[times.size()];
		    				sdf.put("主题", dsd);
		    			}
		    		}
					dsd[times.indexOf("\""+is.getsTime()+"\"")]=String.valueOf(is.getsCount());
				}
	    	}
		}
		StringBuffer sb=new StringBuffer();
		for (Entry<String, String[]> entry : sdf.entrySet()) {
	    	sb.append("{name:'").append(entry.getKey()).append("',type:'line',stack: '总量',data:").append(Arrays.toString(entry.getValue())).append("},");
	    }
		System.out.println(sb.toString());
    	String data=sb.toString().replace("null", "0");
		return data.substring(0,data.lastIndexOf(","));
	}
	
	/**
	 * 信息统计中间图表统计x轴
	 * @return
	 */
	public List<String> integrStic4x(){
		return statisticDao.integrStic4x();
	}
	
	/**
	 * 信息统计中间图表统计y轴
	 * @return
	 */
	public List<String> integrStic4y(){
		return statisticDao.integrStic4y();
	}
}