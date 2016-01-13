package com.jusfoun.catalog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.ResourceInfoDao;
import com.jusfoun.catalog.entity.ResourceInfo;

/**
 * 资源SV
 * @author liudebin
 *
 */
@Service
public class ResourceService extends CrudService<ResourceInfoDao, ResourceInfo>{

	/**
	 * 获取列表个数
	 * @param rsc
	 * @return
	 */
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

	/**
	 * 更新资源
	 * @param rsc
	 */
	@Transactional(readOnly = false)
	public void updateRsc(ResourceInfo rsc) {
		dao.update(rsc);
	}
	
}
