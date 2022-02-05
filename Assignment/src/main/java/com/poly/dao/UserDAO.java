package com.poly.dao;

import java.util.List;

import com.poly.entity.User;

public interface UserDAO {
	User findById(Integer id);
	User findByEmail(String email);
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
	List<User> findAll();
	List<User> findAll(int pageNum, int sizeNum);
	User create(User u);
	User update(User u);
	User delete(User u);
}
