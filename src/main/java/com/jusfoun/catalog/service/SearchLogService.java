package com.jusfoun.catalog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.SearchLogDao;
import com.jusfoun.catalog.entity.SearchLog;

@Service
@Transactional(readOnly=true)
public class SearchLogService extends CrudService<SearchLogDao, SearchLog> {

}