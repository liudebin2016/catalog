package com.jusfoun.catalog.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jusfoun.catalog.common.entity.Page;
import com.jusfoun.catalog.common.mapper.JsonMapper;
import com.jusfoun.catalog.entity.Office;
import com.jusfoun.catalog.vo.ETreeNode;  

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring-context.xml"})  
public class OfficeDaoTest {
	
	@Autowired
	OfficeDao officeDao;

	@Test
	public void testFindPage() {
		List<ETreeNode> etnList=officeDao.findByPid(0);
		List<ETreeNode> last=getChildren(etnList);
		System.out.println(JsonMapper.toJsonString(last));
	}

	public List<ETreeNode> getChildren(List<ETreeNode> etnList){
		for(ETreeNode ent:etnList){
			List<ETreeNode> sdf=officeDao.findByPid(ent.getId());
			if(sdf!=null){
				ent.setChildren(sdf);
				getChildren(sdf);
			}
		}
		
		return etnList;
	}

}
