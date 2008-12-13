package com.kubja.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.kubja.user.domain.User;
import com.kubja.user.repository.UserDao;

@Transactional(readOnly = true)
public class UserManagerImpl implements UserManager {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional(readOnly = false)
	@Override
	public void addUser(User u) {
		u.setLogin(u.getLogin().trim().toLowerCase());
		userDao.addUser(u);
	}

	@Override
	public User getUserByLogin(String login) {
		return userDao.getUserByLogin(login);
	}

	@Transactional(readOnly = true)
	@Override
	public void removeUser(User u) {
		userDao.removeUser(u);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateUser(User u) {
		userDao.updateUser(u);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}
