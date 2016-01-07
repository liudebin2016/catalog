package com.jusfoun.catalog.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration; 
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jusfoun.catalog.entity.SubjectInfo;  

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring-context.xml"})  
public class SubjectInfoDaoTest {
	
	@Autowired
	SubjectInfoDao subjectInfoDao;

	@Test
	public void testDeleteByPrimaryKey() {
		SubjectInfo si=new SubjectInfo();
		si.setId(3);
		subjectInfoDao.delete(si);
	}

	@Test
	public void testInsertSubjectInfo() {
		SubjectInfo si=new SubjectInfo();
		si.setName("主题3");
		subjectInfoDao.insert(si);
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

}
