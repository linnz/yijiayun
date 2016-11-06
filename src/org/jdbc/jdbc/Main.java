package org.jdbc.jdbc;

import org.jdbc.dao.UserDao;
import org.jdbc.dao.UserDaoJdbcImpl;
import org.jdbc.dao.UserDaoJpaImpl;
import org.jdbc.entity.User;

public class Main {

	public static void main(String[] args) throws Exception {
		UserDao userDao = null;

		// jdbc
		userDao = new UserDaoJdbcImpl();
		userDao.deleteAll();
		userDao.insert(new User("001", "Tom", "123"));
		userDao.update(new User("001", "Tom", "456"));
		System.out.println(userDao.findById("001"));
		
		// jpa
		userDao = new UserDaoJpaImpl();
		userDao.deleteAll();
		userDao.insert(new User("001", "Tom", "123"));
		userDao.update(new User("001", "Tom", "456"));
		System.out.println(userDao.findById("001"));
	}

}
