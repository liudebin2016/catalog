package com.jusfoun.catalog.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jusfoun.catalog.common.entity.Page;
import com.jusfoun.catalog.entity.ResourceInfo;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring-context.xml"}) 
public class ResourceServiceTest {

	@Autowired
	ResourceService resourceService;
	
	@Test
	public void testFindPagePageOfResourceInfoResourceInfo() {
		Page<ResourceInfo> srcInfoPage=new Page<ResourceInfo>();
		ResourceInfo ri=new ResourceInfo();
		srcInfoPage.setPageSize(2);
		srcInfoPage.setCount(10);
		Page<ResourceInfo> sip=resourceService.findPage(srcInfoPage, ri);
		System.out.println(sip.getHtml());
	}

}
