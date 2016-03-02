package com.jusfoun.catalog.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.SearchLogDao;
import com.jusfoun.catalog.entity.SearchLog;
import com.jusfoun.catalog.vo.SearchAnalysis;

@Service
@Transactional(readOnly=true)
public class SearchLogService extends CrudService<SearchLogDao, SearchLog> {
	
	@Autowired
	private SearchLogDao searchLogDao;
	
	/**
	 * 热门词
	 * @param paraMaps 
	 * @return
	 */
	public List<SearchAnalysis> hotWord(Map<String, Date> paraMaps){
		return searchLogDao.hotWord(paraMaps);
	}
	
	/**
	 * 热门机构
	 * @param paraMaps 
	 * @return
	 */
	public List<SearchAnalysis> hotOffice(Map<String, Date> paraMaps){
		return searchLogDao.hotOffice(paraMaps);
	}
	
	/**
	 * 获取半年内有搜索时间
	 * @return
	 */
	public List<String> getHalfOfYearRshTime(){
		return searchLogDao.getHalfOfYearRshTime();
	}
	
	/**
	 * 获取搜索类型
	 * @return
	 */
	public List<String> getRshTypeByTime(){
		return searchLogDao.getRshTypeByTime();
	}
	
	/**
	 * 获取统计图表的数据
	 * @param rshCount
	 */
	public List<SearchAnalysis> getRshDataByTime(int rshCount){
		return searchLogDao.getRshDataByTime(rshCount);
	}

}