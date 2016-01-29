package com.jusfoun.catalog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.ResourceInfoDao;
import com.jusfoun.catalog.entity.Register;
import com.jusfoun.catalog.entity.ResourceInfo;

/**
 * 资源SV
 * @author liudebin
 *
 */
@Service
public class ResourceService extends CrudService<ResourceInfoDao, ResourceInfo>{

	@Autowired
	private RegisterService registerService;
	
	/**
	 * 获取列表个数
	 * @param rsc
	 * @return
	 */
	public int findListCount(ResourceInfo rsc) {
		return dao.findListCount(rsc);
	}

	/**根据机构id查询关联的资源
	 * @param officeId 机构id
	 * @return
	 */
	public List<ResourceInfo> findResourceByOfficeId(Integer officeId) {
		return dao.findResourceByOfficeId(officeId);
	}

	/**
	 * 更新资源
	 * @param rsc
	 */
	@Transactional(readOnly = false)
	public void updateRsc(ResourceInfo rsc) {
		dao.update(rsc);
	}
	
	/**
	 * 根据主题Id获取业务数量
	 * @param sqlMap
	 * @return
	 */
	public int findListCountBySubId(Map<String, Object> sqlMap){
		return dao.findListCountBySubId(sqlMap);
	}
	
	/**
	 * 根据主题Id获取业务
	 * @param sqlMap
	 * @return
	 */
	public List<ResourceInfo> findListBySubId(Map<String, Object> sqlMap){
		return dao.findListBySubId(sqlMap);
	}

	public int findListCountByBizId(Map<String, Object> sqlMap) {
		return dao.findListCountByBizId(sqlMap);
	}

	public List<ResourceInfo> findListByBizId(Map<String, Object> sqlMap) {
		return dao.findListByBizId(sqlMap);
	}
	
	/**
	 * 批量更新资源
	 * @param subId
	 * @param opType 
	 * @param params
	 */
	@Transactional(readOnly = false)
	public void batchUpdateRsc(Integer subId, Integer opType, String params) {
		for(String str:params.split(",")){
			ResourceInfo rsc=new ResourceInfo();
			rsc.setId(Integer.valueOf(str));
			if(subId!=null){
				rsc.setSubjectId(subId);
			}
			if(opType!=null){
				rsc.setStatus(opType.toString());
			}
			dao.update(rsc);
			registerService.apply(Integer.valueOf(str), Register.TYPE_BUSINESS);
		}
	}

	public List<ResourceInfo> findSrhList(ResourceInfo rsc) {
		return dao.findSrhList(rsc);
	}

	public int findSrhListCount(ResourceInfo rsc) {
		return dao.findSrhListCount(rsc);
	}
	
}
