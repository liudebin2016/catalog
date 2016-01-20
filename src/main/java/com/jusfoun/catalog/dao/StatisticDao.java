package com.jusfoun.catalog.dao;

import java.util.List;
import java.util.Map;

import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.entity.Statistic;

@MyBatisDao
public interface StatisticDao {
	
	int findListCount();

	List<Statistic> findList(Map<String, String> paraMaps);

}
