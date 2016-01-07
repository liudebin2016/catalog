package com.jusfoun.catalog.dao;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.entity.SubjectInfo;

/**
 * 主题接口
 * @author liudebin
 *
 */
@MyBatisDao
public interface SubjectInfoDao  extends CrudDao<SubjectInfo> {

}