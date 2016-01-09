package com.jusfoun.catalog.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jusfoun.catalog.common.service.TreeService;
import com.jusfoun.catalog.dao.OfficeDao;
import com.jusfoun.catalog.entity.Office;
import com.jusfoun.catalog.utils.UserUtils;

/**
 * 机构Service
 * @author Connor
 * @version 2015-05-16
 */
@Service
@Transactional(readOnly = true)
public class OfficeService extends TreeService<OfficeDao, Office> {

	public List<Office> findAll(){
		return UserUtils.getOfficeList();
	}
	
	public List<Office> findList(Boolean isAll){
		if (isAll != null && isAll){
			return UserUtils.getOfficeAllList();
		}else{
			return UserUtils.getOfficeList();
		}
	}
	
	@Transactional(readOnly = true)
	public List<Office> findList(Office office){
//		office.setParentIds(office.getParentIds()+"%");
		office.setParentIds(0);
		return dao.findByParentIdsLike(office);
	}
	
	@Transactional(readOnly = false)
	public void save(Office office) {
		super.save(office);
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
	}
	
	@Transactional(readOnly = false)
	public void delete(Office office) {
		super.delete(office);
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
	}

	/**
	 * @param parentId 父机构id
	 * @param name 当前机构名称
	 * @param code 国际代码
	 * @return
	 */
	@Transactional(readOnly = false)
	public void insert(Integer parentId, String name, String code) {
		Office parent = null;
		if(parentId.intValue() == 0){
			parent = new Office();
			parent.setId(0);
		}else{
			parent = dao.get(parentId);
		}
		Office office = new Office();
		office.setParent(parent);
		office.setName(name);
		office.setCode(StringUtils.isEmpty(code) ? "--" : code);
		office.setCreateBy(UserUtils.getUser());
		office.setCreateDate(new Date());
		dao.insert(office);
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
	}
}
