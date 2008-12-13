package com.kubja.user.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.kubja.user.domain.User;

public class UserDaoImpl implements UserDao {
	private HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void addUser(User u) {
		this.hibernateTemplate.save(u);
	}

	@Override
	public User getUserByLogin(String login) {
		return (User)this.hibernateTemplate.get(User.class, login);
	}

	@Override
	public void removeUser(User u) {
		this.hibernateTemplate.delete(u);
	}

	@Override
	public void updateUser(User u) {
		this.hibernateTemplate.update(u);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = hibernateTemplate.find("from User");
		return users;
	}

}
