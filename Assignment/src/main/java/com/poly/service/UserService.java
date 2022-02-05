package com.poly.service;

import java.util.List;

import com.poly.entity.User;

public interface UserService {
	User findById(Integer id);
	User findByEmail(String email);
	User findByUsername(String username);
	User login(String username, String password);
	User resetPassword(String email);
	List<User> findAll();
	List<User> findAll(int pageNum, int sizeNum);
	User create(String username, String password, String email, String fullname);
	User update(User u);
	User delete(String username);
}
