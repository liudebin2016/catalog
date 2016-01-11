package com.jusfoun.catalog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.ResourceInfoDao;
import com.jusfoun.catalog.entity.ResourceInfo;
import com.jusfoun.catalog.entity.SubjectInfo;
import com.jusfoun.catalog.vo.CatalogTree;

/**
 * 资源SV
 * @author liudebin
 *
 */
@Service
public class ResourceService extends CrudService<ResourceInfoDao, ResourceInfo>{
	
	@Autowired
	private ResourceInfoDao resourceInfoDao;

	public List<CatalogTree> getResourceCatalogTree(ResourceInfo resourceInfo) {
		List<CatalogTree> ctList=new ArrayList<CatalogTree>();
		List<SubjectInfo> siList=resourceInfoDao.findRscClList(resourceInfo);
		if(null!=siList&&siList.size()>0){
			for(SubjectInfo si:siList){
				CatalogTree ct=new CatalogTree();
				ct.setId(si.getId());
				ct.setName(si.getName());
				ct.setIsOpen(false);
				if(si.getParentId()!=null){
					ct.setPid(si.getParentId());
				}else{
					ct.setPid(0);
				}
				ctList.add(ct);
			}
		}
		return ctList;
	}
	
}
