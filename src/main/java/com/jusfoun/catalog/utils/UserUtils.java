package com.jusfoun.catalog.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.jusfoun.catalog.common.service.BaseService;
import com.jusfoun.catalog.common.tool.CacheTool;
import com.jusfoun.catalog.common.tool.SpringContextHolderTool;
import com.jusfoun.catalog.dao.AreaDao;
import com.jusfoun.catalog.dao.MenuDao;
import com.jusfoun.catalog.dao.OfficeDao;
import com.jusfoun.catalog.dao.RoleDao;
import com.jusfoun.catalog.dao.UserDao;
import com.jusfoun.catalog.entity.Area;
import com.jusfoun.catalog.entity.Menu;
import com.jusfoun.catalog.entity.Office;
import com.jusfoun.catalog.entity.Role;
import com.jusfoun.catalog.entity.User;
import com.jusfoun.catalog.security.SystemAuthorizingRealm.Principal;
import com.jusfoun.catalog.vo.CatalogTree;

/**
 * 用户工具类
 * @author Connor
 * @version 2015-12-18
 */
public class UserUtils {

	private static UserDao userDao = SpringContextHolderTool.getBean(UserDao.class);
	private static RoleDao roleDao = SpringContextHolderTool.getBean(RoleDao.class);
	private static MenuDao menuDao = SpringContextHolderTool.getBean(MenuDao.class);
	private static AreaDao areaDao = SpringContextHolderTool.getBean(AreaDao.class);
	private static OfficeDao officeDao = SpringContextHolderTool.getBean(OfficeDao.class);

	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_LOGIN_NAME_ = "ln";
	public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";

	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";
	public static final String CACHE_OFFICE_TREE = "officeTree";


	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	public static User get(Integer id){
		User user = (User)CacheTool.get(USER_CACHE, USER_CACHE_ID_ + id);
		if (user ==  null){
			user = userDao.get(id);
			if (user == null){
				return null;
			}
			user.setRoleList(roleDao.findList(new Role(user)));
			CacheTool.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheTool.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
		}
		return user;
	}

	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static User getByLoginName(String loginName){
		User user = (User)CacheTool.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + loginName);
		if (user == null){
			user = userDao.getByLoginName(new User(null, loginName));
			if (user == null){
				return null;
			}
			user.setRoleList(roleDao.findList(new Role(user)));
			CacheTool.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheTool.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
		}
		putCache("userName", user.getName());
		putCache("userId", user.getId());
		return user;
	}

	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache(){
		removeCache(CACHE_ROLE_LIST);
		removeCache(CACHE_MENU_LIST);
		removeCache(CACHE_AREA_LIST);
		removeCache(CACHE_OFFICE_LIST);
		removeCache(CACHE_OFFICE_ALL_LIST);
		removeCache(CACHE_OFFICE_TREE);
		UserUtils.clearCache(getUser());
	}

	/**
	 * 清除指定用户缓存
	 * @param user
	 */
	public static void clearCache(User user){
		CacheTool.remove(USER_CACHE, USER_CACHE_ID_ + user.getId());
		CacheTool.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName());
		CacheTool.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getOldLoginName());
		if (user.getOffice() != null && user.getOffice().getId() != null){
			CacheTool.remove(USER_CACHE, USER_CACHE_LIST_BY_OFFICE_ID_ + user.getOffice().getId());
		}
	}

	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static User getUser(){
		Principal principal = getPrincipal();
		if (principal!=null){
			User user = get(principal.getId());
			if (user != null){
				return user;
			}
			return new User();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new User();
	}

	/**
	 * 获取当前用户角色列表
	 * @return
	 */
	public static List<Role> getRoleList(){
		@SuppressWarnings("unchecked")
		List<Role> roleList = (List<Role>)getCache(CACHE_ROLE_LIST);
		if (roleList == null){
			User user = getUser();
			if (user.isAdmin()){
				roleList = roleDao.findAllList(new Role());
			}else{
				Role role = new Role();
//				role.getSqlMap().put("dsf", BaseService.dataScopeFilter(user.getCurrentUser(), "o", "u"));
				roleList = roleDao.findList(role);
			}
			putCache(CACHE_ROLE_LIST, roleList);
		}
		return roleList;
	}

	/**
	 * 获取当前用户授权菜单
	 * @return
	 */
	public static List<Menu> getMenuList(){
		@SuppressWarnings("unchecked")
		List<Menu> menuList = (List<Menu>)getCache(CACHE_MENU_LIST);
		if (menuList == null){
			User user = getUser();
			if (user.isAdmin()){// 系统管理员id为1
//				menuList = menuDao.findAllList(new Menu());
				menuList = menuDao.findSysAdminMenu(new Menu());
			}else{// 部门管理员
//				Menu m = new Menu();
//				m.setUserId(user.getId());
//				menuList = menuDao.findByUserId(m);
				menuList = menuDao.findDeptAdminMenu(new Menu());
			}

			Menu menuTree1 = MenuUtils.buildTree(menuList);
			putCache("menuTree",menuTree1.getChildren());
			putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}

	/**
	 * 获取当前用户授权的区域
	 * @return
	 */
	public static List<Area> getAreaList(){
		@SuppressWarnings("unchecked")
		List<Area> areaList = (List<Area>)getCache(CACHE_AREA_LIST);
		if (areaList == null){
			areaList = areaDao.findAllList(new Area());
			putCache(CACHE_AREA_LIST, areaList);
		}
		return areaList;
	}

	/**
	 * 获取当前用户有权限访问的部门
	 * @return
	 */
	public static List<Office> getOfficeList(){
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>)getCache(CACHE_OFFICE_LIST);
		if (officeList == null){
			User user = getUser();
			if (user.isAdmin()){
				officeList = officeDao.findAllList(new Office());
			}else{
				Office office = new Office();
				office.getSqlMap().put("dsf", BaseService.dataScopeFilter(user, "a", ""));
				officeList = officeDao.findList(office);
			}
			putCache(CACHE_OFFICE_LIST, officeList);
		}
		return officeList;
	}
	
	/**
	 * 获取当前用户有权限访问的部门树
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<CatalogTree> getOfficeTree() {
		List<CatalogTree> tree = (List<CatalogTree>) getCache(CACHE_OFFICE_TREE);
		if (tree == null) {
			tree = new ArrayList<CatalogTree>();
			List<Office> officeList = null;
			User user = getUser();
			if (user.isAdmin()) {
				officeList = officeDao.findAllList(new Office());
			} else {
				Office office = new Office();
				office.getSqlMap().put("dsf", BaseService.dataScopeFilter(user, "a", ""));
				officeList = officeDao.findList(office);
			}
			if (officeList != null && !officeList.isEmpty()) {
				for(Office ofe : officeList){
					CatalogTree node = new CatalogTree();
					node.setId(ofe.getId());
					node.setFullName(ofe.getName());
					node.setName(ofe.getName().length()>10? (ofe.getName().substring(0, 10)+"...") : ofe.getName() );
					node.setOpen(false);
					node.setpId(ofe.getParentId()==null ? 0 : ofe.getParentId());
					node.setStatus(ofe.getStatus());
					tree.add(node);
				}
				putCache(CACHE_OFFICE_TREE, tree);
			}
		}
		return tree;
	}

	/**
	 * 获取当前用户有权限访问的部门
	 * @return
	 */
	public static List<Office> getOfficeAllList(){
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>)getCache(CACHE_OFFICE_ALL_LIST);
		if (officeList == null){
			officeList = officeDao.findAllList(new Office());
		}
		return officeList;
	}

	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}

	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal)subject.getPrincipal();
			if (principal != null){
				return principal;
			}
//			subject.logout();
		}catch (UnavailableSecurityManagerException e) {

		}catch (InvalidSessionException e){

		}
		return null;
	}

	public static Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
//			subject.logout();
		}catch (InvalidSessionException e){

		}
		return null;
	}

	// ============== User Cache ==============

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
//		Object obj = getCacheMap().get(key);
		Object obj = getSession().getAttribute(key);
		return obj==null?defaultValue:obj;
	}

	public static void putCache(String key, Object value) {
//		getCacheMap().put(key, value);
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
//		getCacheMap().remove(key);
		getSession().removeAttribute(key);
	}

//	public static Map<String, Object> getCacheMap(){
//		Principal principal = getPrincipal();
//		if(principal!=null){
//			return principal.getCacheMap();
//		}
//		return new HashMap<String, Object>();
//	}

} 
