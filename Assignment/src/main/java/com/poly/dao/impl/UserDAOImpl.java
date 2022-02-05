package com.poly.dao.impl;

import java.util.List;

import com.poly.dao.AbstractDAO;
import com.poly.dao.UserDAO;
import com.poly.entity.User;

public class UserDAOImpl extends AbstractDAO<User> implements UserDAO{

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "SELECT o FROM User o WHERE o.email = ?0";
		return super.findOne(User.class, sql, email);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT o FROM User o WHERE o.username = ?0";
		return super.findOne(User.class, sql, username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT o FROM User o WHERE o.username = ?0 AND o.password = ?1";
		return super.findOne(User.class, sql, username, password);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(User.class, true);
	}

	@Override
	public List<User> findAll(int pageNum, int sizeNum) {
		// TODO Auto-generated method stub
		return super.findAll(null, true, pageNum, sizeNum);
	}

}
