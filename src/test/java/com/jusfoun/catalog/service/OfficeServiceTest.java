package com.jusfoun.catalog.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jusfoun.catalog.common.entity.Page;
import com.jusfoun.catalog.entity.Office;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring-context.xml"})  
public class OfficeServiceTest {

	@Autowired
	OfficeService officeService;
	
	@Test
	public void testFindPage() {
		Page<Office> oInfoPage=new Page<Office>();
		Office office=new Office();
		oInfoPage.setPageSize(3);
		Page<Office> sip=officeService.findPage(oInfoPage, office);
		System.out.println(sip.getHtml());
	}

}
