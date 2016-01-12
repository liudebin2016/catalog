package com.jusfoun.catalog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.SubjectInfoDao;
import com.jusfoun.catalog.entity.SubjectInfo;
import com.jusfoun.catalog.vo.CatalogTree;

/**
 * 主题SV
 * @author liudebin
 *
 */
@Service
public class SubjectService extends CrudService<SubjectInfoDao, SubjectInfo>{
	
	@Transactional(readOnly = false)
	public boolean saveSubjectInfo(SubjectInfo subjectInfo){
		int num=dao.insert(subjectInfo);
		if(num>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 获取主题目录树
	 * @param subjectInfo
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<CatalogTree> getSubjectCatalogTree(SubjectInfo subjectInfo){
		List<CatalogTree> ctList=new ArrayList<CatalogTree>();
		List<SubjectInfo> siList=dao.findAllList(subjectInfo);
		if(null!=siList&&siList.size()>0){
			for(SubjectInfo si:siList){
				CatalogTree ct=new CatalogTree();
				ct.setId(si.getId());
				ct.setName(si.getName());
				ct.setIsOpen(false);
				if(si.getParentId()!=null){
					ct.setPId(si.getParentId());
				}else{
					ct.setPId(0);
				}
				ctList.add(ct);
			}
		}
		return ctList;
	}

	/**
	 * 更新主题
	 * @param si
	 * @return
	 */
	public boolean update(SubjectInfo si) {
		int ucount=dao.update(si);
		if(ucount>0){
			return true;
		}
		return false;
	}
}
