package com.lanqiao.store.dao;

import com.lanqiao.store.model.User;

public interface UserDao {

	User findUserByName(String username);

	void addNewUser(User user);

	
}
