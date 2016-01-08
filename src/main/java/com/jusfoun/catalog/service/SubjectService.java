package com.jusfoun.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.SubjectInfoDao;
import com.jusfoun.catalog.entity.SubjectInfo;

/**
 * 主题SV
 * @author liudebin
 *
 */
@Service

public class SubjectService extends CrudService<SubjectInfoDao, SubjectInfo>{
	
	@Autowired
	private SubjectInfoDao subjectInfoDao;
	
	@Transactional(readOnly = false)
	public boolean saveSubjectInfo(SubjectInfo subjectInfo){
		int num=subjectInfoDao.insert(subjectInfo);
		if(num>0){
			return true;
		}
		return false;
	}
	
	
}
