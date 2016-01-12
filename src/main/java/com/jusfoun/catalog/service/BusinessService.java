package com.jusfoun.catalog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.BusinessDao;
import com.jusfoun.catalog.entity.Business;

@Service
@Transactional(readOnly = true)
public class BusinessService extends CrudService<BusinessDao, Business>{
	
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

	public int findListCount(Business biz) {
		return dao.findListCount(biz);
	}

}
