package com.jusfoun.catalog.dao;

import java.util.List;
import java.util.Map;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.entity.IntegrStic;
import com.jusfoun.catalog.entity.Statistic;

@MyBatisDao
public interface StatisticDao {
	
	int findListCount();

	List<Statistic> findList(Map<String, Integer> paraMaps);
	
	/**
	 * 信息统计中间图表统计
	 * @return
	 */
	List<IntegrStic> integrStic();
	
	/**
	 * 信息统计中间图表统计x轴
	 * @return
	 */
	List<String> integrStic4x();
	
	/**
	 * 信息统计中间图表统计y轴
	 * @return
	 */
	List<String> integrStic4y();

}
