package com.jusfoun.catalog.service;

import java.util.ArrayList;
import java.util.List;

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

	public List<CatalogTree> getResourceCatalogTree(ResourceInfo resourceInfo) {
		List<CatalogTree> ctList=new ArrayList<CatalogTree>();
		List<SubjectInfo> siList=dao.findRscClList(resourceInfo);
		if(null!=siList&&siList.size()>0){
			for(SubjectInfo si:siList){
				CatalogTree ct=new CatalogTree();
				ct.setId(si.getId());
				ct.setName(si.getName());
				ct.setIsOpen(false);
				if(si.getParentId()!=null){
					ct.setPId(si.getParentId());
				}else{
					ct.setPId(0);
				}
				ctList.add(ct);
			}
		}
		return ctList;
	}

	public int findListCount(ResourceInfo rsc) {
		return dao.findListCount(rsc);
	}

	/**根据机构id查询关联的资源
	 * @param officeId 机构id
	 * @return
	 */
	public List<ResourceInfo> findResourceByOfficeId(Integer officeId) {
		return dao.findResourceByOfficeId(officeId);
	}
	
}
