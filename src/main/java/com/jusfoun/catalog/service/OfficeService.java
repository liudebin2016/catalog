package com.jusfoun.catalog.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jusfoun.catalog.common.entity.Page;
import com.jusfoun.catalog.common.service.TreeService;
import com.jusfoun.catalog.dao.CatalogInfoDao;
import com.jusfoun.catalog.dao.OfficeDao;
import com.jusfoun.catalog.entity.CatalogInfo;
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
	
	@Resource
	private CatalogInfoDao catalogInfoDao;
	
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
	public void delete(Integer id) {
		if(id==null || id.intValue() == 0)
			return;
		// delete Office
		Office office = new Office();
    	office.setId(id);
		super.delete(office);
		// delete CatalogInfo
		CatalogInfo catalog = new CatalogInfo();
		catalog.setOfficeId(id);
		catalog.setType(CatalogInfo.TYPE_OFFICE);
		catalogInfoDao.delete(catalog);
		// remove cache
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
		Date date = new Date();
		// insert Office
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
		office.setCreateBy(UserUtils.getUser());
		office.setCreateDate(date);
		dao.insert(office);
		// insert CatlogInfo
		CatalogInfo catalog = new CatalogInfo();
		catalog.setType(CatalogInfo.TYPE_OFFICE);
		catalog.setTypeValue(code);
		catalog.setOfficeId(office.getId());
		catalog.setCreateBy(UserUtils.getUser());
		catalog.setCreateDate(date);
		catalogInfoDao.insert(catalog);
		// remove cache
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
	}
	
	/**
	 * @param id 节点id
	 * @param name	节点名称
	 * @param code 国际代码
	 */
	@Transactional(readOnly = false)
	public void update(Integer id, String name, String code) {
		Date date = new Date();
		// update Office
		Office office = new Office();
		office.setId(id);
		office.setName(name);
		office.setUpdateBy(UserUtils.getUser());
		office.setUpdateDate(date);
		dao.update(office);
		if(StringUtils.isEmpty(code))
			return;
		// update CatalogInfo
		CatalogInfo catalog = new CatalogInfo();
		catalog.setOfficeId(id);
		catalog.setType(CatalogInfo.TYPE_OFFICE);
		catalog.setTypeValue(code);
		office.setUpdateBy(UserUtils.getUser());
		office.setUpdateDate(date);
		CatalogInfo c = catalogInfoDao.get(catalog);
		if(c == null)
			catalogInfoDao.insert(catalog);
		else
			catalogInfoDao.update(catalog);
		// remove cache
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
	}
	
	@Transactional(readOnly = false)
	public void updateOfficeById(int id,String content) {
		dao.updateOfficeById(id,content);
		
	}
	
	public Page<Office> findPage(Page<Office> page, Office office) {
		office.setDelFlag("0");
		office.getSqlMap().put("dsf", "limit "+page.getPageNo()+","+page.getPageSize());
		office.setPage(page);
		page.setList(dao.findList(office));
		return page;
	}
}
