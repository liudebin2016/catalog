package com.jusfoun.catalog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.SubjectInfoDao;
import com.jusfoun.catalog.entity.ResourceInfo;
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
				ct.setFullName(si.getName());
				ct.setName(si.getName().length()>10? (si.getName().substring(0, 10)+"...") : si.getName());
				ct.setOpen(false);
				ct.setStatus(si.getStatus().toString());
				if(si.getParentId()!=null){
					ct.setpId(si.getParentId());
				}else{
					ct.setpId(0);
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

	public int findListCountByBizId(Map<String, Object> sqlMap) {
		return dao.findListCountByBizId(sqlMap);
	}

	public List<ResourceInfo> findListByBizId(Map<String, Object> sqlMap) {
		return dao.findListByBizId(sqlMap);
	}

	public int findListCountByRscId(Map<String, Object> sqlMap) {
		return dao.findListCountByRscId(sqlMap);
	}

	public List<ResourceInfo> findListByRscId(Map<String, Object> sqlMap) {
		return dao.findListByRscId(sqlMap);
	}

	/**
	 * 前端搜索使用
	 * @param sub
	 * @return
	 */
	public List<ResourceInfo> findSrhList(SubjectInfo sub) {
		return dao.findSrhList(sub);
	}

	/**
	 * 前端搜索使用
	 * @param sub
	 * @return
	 */
	public int findSrhListCount(SubjectInfo sub) {
		return dao.findSrhListCount(sub);
	}

	public void findListCount(SubjectInfo si) {
		dao.findListCount(si);
	}
}
