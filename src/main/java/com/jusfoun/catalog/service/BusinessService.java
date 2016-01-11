package com.jusfoun.catalog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.BusinessDao;
import com.jusfoun.catalog.entity.Business;

@Service
public class BusinessService extends CrudService<BusinessDao, Business>{
	
	@Transactional(readOnly = false)
	public boolean updateBiz(Business biz){
		int num=dao.update(biz);
		if(num>0){
			return true;
		}
		return false;
	}

}
