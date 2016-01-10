package com.jusfoun.catalog.service;

import org.springframework.stereotype.Service;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.BusinessDao;
import com.jusfoun.catalog.entity.Business;

@Service
public class BusinessService extends CrudService<BusinessDao, Business>{

}
