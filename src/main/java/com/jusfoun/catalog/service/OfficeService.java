package com.jusfoun.catalog.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.jusfoun.catalog.vo.CatalogTree;
import com.jusfoun.catalog.vo.ETreeNode;

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
	
	public List<CatalogTree> getOfficeTree(){
		return UserUtils.getOfficeTree();
	}
	
	public List<Office> findList(Boolean isAll){
		if (isAll != null && isAll){
			return UserUtils.getOfficeAllList();
		}else{
			return UserUtils.getOfficeList();
		}
	}
	
	public List<Office> queryOffices(Map<String,Object> param){
		return dao.queryOffices(param);
	}
	
	@Transactional(readOnly = true)
	public List<Office> findList(Office office){
//		office.setParentIds(office.getParentIds()+"%");
		office.setParentIds("0");
		return dao.findByParentIdsLike(office);
	}
	
	@Transactional(readOnly = false)
	public void save(Office office) {
		super.save(office);
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_TREE);
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
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_TREE);
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
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_TREE);
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
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_TREE);
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

	/**
	 * @param id	被拖拽节点id
	 * @param targetId 目标节点id
	 * @param moveType 拖拽类型
	 */
	@Transactional(readOnly = false)
	public void drag(Integer id, Integer targetId, String moveType) {
		Office parent = new Office();
		if("inner".equals(moveType)){
			parent.setId(targetId);
		}else{
			Office target = dao.get(targetId);
			parent.setId(target.getParentId());
		}
		Office office = dao.get(id);
		office.setParent(parent);
		office.setUpdateBy(UserUtils.getUser());
		office.setUpdateDate(new Date());
		dao.updateParentIds(office);
		dao.update(office);
		// remove cache
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_TREE);
	}

	@Transactional(readOnly = false)
	public void update(Office office) {
		dao.update(office);		
	}
	
	public List<ETreeNode> getChildren(List<ETreeNode> etnList){
		for(ETreeNode ent:etnList){
			List<ETreeNode> sdf=dao.findByPid(ent.getId());
			if(sdf!=null){
				ent.setChildren(sdf);
				getChildren(sdf);
			}
		}
		
		return etnList;
	}
	
	public List<ETreeNode> buildETreeNode(int pid){
		List<ETreeNode> etnList=dao.findByPid(0);
		List<ETreeNode> last=getChildren(etnList);
		return last;
	}
}
