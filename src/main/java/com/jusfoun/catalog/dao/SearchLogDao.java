package com.jusfoun.catalog.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.entity.SearchLog;
import com.jusfoun.catalog.vo.SearchAnalysis;

@MyBatisDao
public interface SearchLogDao extends CrudDao<SearchLog> {

	/**
	 * 热门词
	 * @param paraMaps 
	 * @return
	 */
	public List<SearchAnalysis> hotWord(Map<String, Date> paraMaps);
	
	/**
	 * 热门机构
	 * @param paraMaps 
	 * @return
	 */
	public List<SearchAnalysis> hotOffice(Map<String, Date> paraMaps);
	
	
	/**
	 * 获取半年内有搜索时间
	 * @return
	 */
	public List<String> getHalfOfYearRshTime();
	
	/**
	 * 获取搜索类型
	 * @return
	 */
	public List<String> getRshTypeByTime();
	
	/**
	 * 获取统计图表的数据
	 * @param rshCount
	 */
	public List<SearchAnalysis> getRshDataByTime(int rshCount);
}
