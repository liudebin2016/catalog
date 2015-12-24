package com.jusfoun.catalog.dao;

import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.entity.Menu;

import java.util.List;

/**
 * 菜单DAO接口
 * @author Connor
 * @version 2014-05-16
 */
@MyBatisDao
public interface MenuDao extends CrudDao<Menu> {

	public List<Menu> findByParentIdsLike(Menu menu);

	public List<Menu> findByUserId(Menu menu);
	
	public int updateParentIds(Menu menu);
	
	public int updateSort(Menu menu);
	
}
