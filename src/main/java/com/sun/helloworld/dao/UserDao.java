package com.sun.helloworld.dao;

import com.sun.helloworld.bean.User;

public interface UserDao {
	
	int insert(User user);
	
	int deleteById(int id);
	
	int updateById(User user);
	
	User selectById(int id);
}
