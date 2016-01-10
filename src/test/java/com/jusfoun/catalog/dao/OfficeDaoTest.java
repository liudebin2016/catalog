package com.jusfoun.catalog.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jusfoun.catalog.common.entity.Page;
import com.jusfoun.catalog.entity.Office;  

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring-context.xml"})  
public class OfficeDaoTest {
	
	@Autowired
	OfficeDao officeDao;

	@Test
	public void testFindPage() {
		Office office=new Office();
		Page<Office> page=new Page<Office>();
		page.setPageSize(2);
		office.setPage(page);
		List<Office> ofcList=officeDao.findPageList(office);
		System.out.println(ofcList.size());
		System.out.println(page.getHtml());
	}


}
