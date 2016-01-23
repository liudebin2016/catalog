package com.jusfoun.catalog.dao;

import java.util.List;
import java.util.Map;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.common.dao.TreeDao;
import com.jusfoun.catalog.entity.Office;
import com.jusfoun.catalog.vo.ETreeNode;


/**
 * 机构DAO接口
 * @author Connor
 * @version 2015-12-18
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	void updateOfficeById(int id,String content);

	List<Office> findPageList(Office office);

	/**查询有效个数
	 * @return
	 */
	Long getCount();

	List<Office> queryOffices(Map<String, Object> param);
	
	List<ETreeNode> findByPid(int pid);
}
