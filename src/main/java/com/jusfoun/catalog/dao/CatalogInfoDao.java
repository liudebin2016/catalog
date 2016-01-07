package com.jusfoun.catalog.dao;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.entity.CatalogInfo;

/**
 * 目录Dao
 * @author liudebin
 *
 */
@MyBatisDao
public interface CatalogInfoDao extends CrudDao<CatalogInfo> {

}