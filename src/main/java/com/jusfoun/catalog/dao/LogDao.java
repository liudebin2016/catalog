package com.jusfoun.catalog.dao;

import java.util.List;

import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.entity.Log;
import com.jusfoun.catalog.vo.LogAndUserView;

/**
 * 日志DAO接口
 * @author Connor
 * @version 2015-12-18
 */
@MyBatisDao
public interface LogDao extends CrudDao<Log> {

	List<LogAndUserView> reloadList(LogAndUserView log);

	int reloadLogListCount(LogAndUserView log);

}
