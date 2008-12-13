package com.kubja.user.repository;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.kubja.user.domain.Address;
import com.kubja.user.domain.User;


public class JdbcUserDaoImplTests extends
		AbstractTransactionalDataSourceSpringContextTests {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	protected String[] getConfigLocations() {
	    return new String[] {"classpath:test-context.xml"};
	}
	@Override
	protected void onSetUpInTransaction() throws Exception {
	    super.deleteFromTables(new String[] {"users"});
	    super.executeSqlScript("file:db/load_data.sql", true);
	}

	private void isUser(User u, int i){
		assertNotNull(u);
		assertEquals("test" + i, u.getLogin());
		assertNull(u.getPassword());
		assertEquals("firstname" + i, u.getFirstname());
		assertEquals("lastname" + i, u.getLastname());
		assertEquals("abc"+ i + "@def.com", u.getEmail());
		Date d = (new GregorianCalendar(1980, i, 3)).getTime();
		assertEquals(d, u.getDob());
		
		Address a = u.getAddress();
		assertEquals("abc" + i + " street", a.getStreet());
		assertEquals("testvegas" + i, a.getCity());
		assertEquals("bangla" + i, a.getState());
		assertEquals("india", a.getCountry());
		assertEquals("56000" + i, a.getZipcode());
	}
	
	private User createUser(int i){
		User u = new User();
		u.setLogin("test" + i);
		u.setFirstname("firstname" + i);
		u.setLastname("lastname" + i);
		u.setEmail("abc" + i + "@def.com");
		Date d = (new GregorianCalendar(1980, i, 3)).getTime();
		u.setDob(d);
		
		Address a = new Address();
		a.setStreet("abc" + i + " street");
		a.setCity("testvegas" + i);
		a.setState("bangla" + i);
		a.setCountry("india");
		a.setZipcode("56000" + i);
		u.setAddress(a);
		
		return u;
	}
	public void testAddGetDeleteRemove(){
		User u = createUser(1);
		userDao.addUser(u);
		
		User uDb = userDao.getUserByLogin("test1");
		assertNotNull(uDb);
		isUser(uDb, 1);
		
		uDb.setLastname("updatedLastName");
		userDao.updateUser(uDb);
		
		uDb = userDao.getUserByLogin("test1");
		assertNotNull(uDb);
		assertEquals("updatedLastName", uDb.getLastname());
		
		userDao.removeUser(uDb);
		uDb = userDao.getUserByLogin("test1");
		assertNull(uDb);
	}
	
	public void testGetAllUsers(){
		User u1 = createUser(1);
		userDao.addUser(u1);
		
		User u2 = createUser(2);
		userDao.addUser(u2);
		
		User u3 = createUser(3);
		userDao.addUser(u3);
		
		List<User> users = userDao.getAllUsers();
		assertEquals(3, users.size());
	}
}
