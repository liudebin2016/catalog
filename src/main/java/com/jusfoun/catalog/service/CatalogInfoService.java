package com.jusfoun.catalog.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.CatalogInfoDao;
import com.jusfoun.catalog.entity.CatalogInfo;
import com.jusfoun.catalog.utils.UserUtils;
@Service
@Transactional(readOnly = true)
public class CatalogInfoService extends CrudService<CatalogInfoDao, CatalogInfo> {

	@Resource
	private CatalogInfoDao catalogInfoDao;

	public void insert(int type, String typeValue, Integer officeId) {
		CatalogInfo catalog = new CatalogInfo();
		catalog.setType(type);
		catalog.setTypeValue(typeValue);
		catalog.setOfficeId(officeId);
		catalog.setCreateBy(UserUtils.getUser());
		catalog.setCreateDate(new Date());
		catalogInfoDao.insert(catalog);
	}

}
