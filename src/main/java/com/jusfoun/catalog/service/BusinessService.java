package com.jusfoun.catalog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.BusinessDao;
import com.jusfoun.catalog.entity.Business;
import com.jusfoun.catalog.entity.Register;

@Service
@Transactional(readOnly = true)
public class BusinessService extends CrudService<BusinessDao, Business>{
	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 更新业务
	 * @param biz
	 * @return
	 */
	@Transactional(readOnly = false)
	public boolean updateBiz(Business biz){
		int num=dao.update(biz);
		if(num>0){
			return true;
		}
		return false;
	}

	/**根据机构d查询对应的业务
	 * @param officeId 机构id
	 * @return
	 */
	public List<Business> findBusinessByOfficeId(Integer officeId) {
		return dao.findBusinessByOfficeId(officeId);
	}

	/**
	 * 查询列表中的个数
	 * @param biz
	 * @return
	 */
	public int findListCount(Business biz) {
		return dao.findListCount(biz);
	}

	public int findListCountBySubId(Map<String, Object> sqlMap){
		return dao.findListCountBySubId(sqlMap);
	}
	
	public List<Business> findListBySubId(Map<String, Object> sqlMap){
		return dao.findListBySubId(sqlMap);
	}

	public int findListCountByRscId(Map<String, Object> sqlMap) {
		return dao.findListCountByRscId(sqlMap);
	}

	public List<Business> findListByRscId(Map<String, Object> sqlMap) {
		return dao.findListByRscId(sqlMap);
	}

	/**
	 * 批量更新业务
	 * @param subId
	 * @param opType 
	 * @param params
	 */
	@Transactional(readOnly = false)
	public void batchUpdateBiz(Integer subId, Integer opType, String params) {
		for(String str:params.split(",")){
			Business biz=new Business();
			biz.setId(Integer.valueOf(str));
			if(subId!=null){
				biz.setSubjectId(subId);
			}
			if(opType!=null){
				biz.setStatus(opType.toString());
			}
			dao.update(biz);
			registerService.apply(Integer.valueOf(str), Register.TYPE_BUSINESS);
		}
	}

	public int findSrhListCount(Business biz) {
		return dao.findSrhListCount(biz);
	}

	public List<Business> findSrhList(Business biz) {
		return dao.findSrhList(biz);
	}

	public void batchUpdateBizCancel(Integer subId, Integer opType, String params) {
		for(String str:params.split(",")){
			Business biz=new Business();
			biz.setId(Integer.valueOf(str));
			if(subId!=null){
				biz.setSubjectId(subId);
			}
			if(opType!=null){
				biz.setStatus(opType.toString());
			}
			dao.update(biz);
			registerService.cancel(Integer.valueOf(str), Register.TYPE_BUSINESS);
		}
		
	}

	public List<Business> getBusByBusId(String busId) {
		String[] ids = busId.split(",");
		List<Business> BusList = new ArrayList<Business>();
		for(String id : ids){
			BusList.add(dao.get(Integer.parseInt(id)));
		}
		return BusList;
	}
}
