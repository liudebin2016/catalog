package com.jusfoun.catalog.dao;

import com.jusfoun.catalog.common.dao.CrudDao;
import com.jusfoun.catalog.common.annotation.MyBatisDao;
import com.jusfoun.catalog.entity.Role;

/**
 * 角色DAO接口
 * @author Connor
 * @version 2015-12-18
 */
@MyBatisDao
public interface RoleDao extends CrudDao<Role> {

	public Role getByName(Role role);
	
	public Role getByEnname(Role role);

	/**
	 * 维护角色与菜单权限关系
	 * @param role
	 * @return
	 */
	public int deleteRoleMenu(Role role);

	public int insertRoleMenu(Role role);
	
	/**
	 * 维护角色与公司部门关系
	 * @param role
	 * @return
	 */
	public int deleteRoleOffice(Role role);

	public int insertRoleOffice(Role role);

}
