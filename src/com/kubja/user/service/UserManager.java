package com.kubja.user.service;

import java.util.List;

import com.kubja.user.domain.User;

public interface UserManager {
	public void addUser(User u);
	public void removeUser(User u);
	public User getUserByLogin(String login);
	public void updateUser(User u);
	public List<User> getAllUsers();
}
