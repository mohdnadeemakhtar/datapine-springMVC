package com.datapine.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datapine.dao.UserDAO;
import com.datapine.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * UserDAO class is autowired in UserServiceImpl.
	 * this provides spring dependency injection
	 */
	@Autowired
	private UserDAO userDAO;

	@Override
	public User register(String email, String password, String userName, String gender) {
		User user = new User(email);
		user.setPassword(password);
		user.setUserName(userName);
		user.setGender(gender);
		userDAO.save(user);
		return user;
	}

	@Override
	public User login(String email, String password) {
		User user = new User(email);
		user.setPassword(password);
		User usr = userDAO.login(user);
		return usr;
	}

	@Override
	public Iterator<User> listOfUsers() {
		return userDAO.findAllOrderById();
	}

	@Override
	public User getUser(Long id) {
		return userDAO.getUserById(id);
	}

	@Override
	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
	}

	@Override
	public boolean deleteUser(Long id) {
		return userDAO.deleteUser(id);
	}

	@Override
	public boolean logout() {
		return userDAO.logout();
	}
	
	@Override
	public User updatePassword(Long userId, String oldPassword,
			String newPassword) {
		return null;
	}


}
