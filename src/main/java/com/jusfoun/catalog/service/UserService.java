package com.jusfoun.catalog.service;

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
		
		return dao.insert(user);
	}

	public boolean updateUser(User user) {
		
		return dao.update(user)>0;
	}
}
