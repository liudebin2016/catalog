package com.jusfoun.catalog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jusfoun.catalog.common.service.CrudService;
import com.jusfoun.catalog.dao.UserDao;
import com.jusfoun.catalog.entity.User;

@Service
@Transactional(readOnly = true)
public class UserService extends CrudService<UserDao, User>{

	
	public long findListCount(User user) {
		return dao.findAllCount(user);
	}

	public int createUser(User user, String officeId) {
		user.setPassword(SystemService.entryptPassword(user.getPassword()));
		return dao.createUser(user);
	}

	public boolean updateUser(User user) {
		
		return dao.updateUser(user)>0;
	}

	public List<User> findUserList(User user) {
		
		return dao.findUserList(user);
	}

	public boolean checkUserName(User user) {
		
		return dao.checkUserName(user)>0;
	}
}
