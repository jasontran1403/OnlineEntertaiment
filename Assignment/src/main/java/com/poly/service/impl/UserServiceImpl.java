package com.poly.service.impl;

import java.util.List;
import java.util.UUID;

import com.poly.dao.UserDAO;
import com.poly.dao.impl.UserDAOImpl;
import com.poly.entity.User;
import com.poly.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO dao;

	public UserServiceImpl() {
		dao = new UserDAOImpl();
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findByUsernameAndPassword(username, password);
	}

	@Override
	public User resetPassword(String email) {
		// TODO Auto-generated method stub
		User existUser = findByEmail(email);
		if (existUser != null) {
			String newPass = String.valueOf((int) (Math.random() * ((9999-1000)+1))+1000);
			existUser.setPassword(newPass);
			return dao.update(existUser);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<User> findAll(int pageNum, int sizeNum) {
		// TODO Auto-generated method stub
		return dao.findAll(pageNum, sizeNum);
	}

	@Override
	public User create(String username, String password, String email, String fullname) {
		; // TODO Auto-generated method stub
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setEmail(email);
		u.setFullname(fullname);
		u.setIsAdmin(Boolean.FALSE);
		u.setIsActive(Boolean.TRUE);
		return dao.create(u);
	}

	@Override
	public User update(User u) {
		// TODO Auto-generated method stub
		return dao.update(u);
	}

	@Override
	public User delete(String username) {
		// TODO Auto-generated method stub
		User user = dao.findByUsername(username);
		user.setIsActive(Boolean.FALSE);
		return dao.delete(user);
	}

}
