package com.jusfoun.catalog.service;

//import com.jusfoun.catalog.common.persistence.Page;
import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.common.tool.DateTool;
import com.jusfoun.catalog.dao.LogDao;
import com.jusfoun.catalog.entity.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 日志Service
 * @author Connor
 * @version 2015-05-16
 */
@Service
@Transactional(readOnly = true)
public class LogService extends CrudService<LogDao, Log> {

	public List<Log> findPage(List<Log> page, Log log) {
		
		// 设置默认时间范围，默认当前月
		if (log.getBeginDate() == null){
			log.setBeginDate(DateTool.setDays(DateTool.parseDate(DateTool.getDate()), 1));
		}
		if (log.getEndDate() == null){
			log.setEndDate(DateTool.addMonths(log.getBeginDate(), 1));
		}
		
//		return super.findPage(page, log);
		return null;
	}
	
}
