package com.lanqiao.store.service;

import com.lanqiao.store.dao.UserDao;
import com.lanqiao.store.dao.impljdbc.UserDaoImpl;
import com.lanqiao.store.model.User;

public class UserService {
	UserDao userDao = new UserDaoImpl();

	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByName(username);
	}

	public void addNewUser(User user) {
		userDao.addNewUser(user);
		
	}

	
	
}
