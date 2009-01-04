package com.kubja.user.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.providers.encoding.PasswordEncoder;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.kubja.user.domain.User;
import com.kubja.user.repository.UserDao;

@Transactional(readOnly = true)
public class UserManagerImpl implements UserManager, UserDetailsService {
	private UserDao userDao;
	private PasswordEncoder passwordEncoder;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional(readOnly = false)
	@Override
	public void addUser(User u) {
		u.setLogin(u.getLogin().trim().toLowerCase());
		u.setAuthStr("ROLE_USER");
		u.setEnabled(true);
		String encPasswd = passwordEncoder.encodePassword(u.getPassword(), u.getUsername());
		u.setPassword(encPasswd);
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

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException, DataAccessException {
		User user = userDao.getUserByLogin(login);
		if(user == null){
			throw new UsernameNotFoundException("User " + login + " does not exist");
		}
		return user;
	}

}
