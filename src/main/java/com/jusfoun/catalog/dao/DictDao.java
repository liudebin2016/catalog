package com.jusfoun.catalog.dao;

import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.entity.Dict;

import java.util.List;

/**
 * 字典DAO接口
 * @author Connor
 * @version 2015-05-16
 */
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {

	public List<String> findTypeList(Dict dict);

	public int findListCount(Dict dict);
	
}
