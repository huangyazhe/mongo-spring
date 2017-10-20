package com.lgp.mongo.dao;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lgp.mongo.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring.xml")
public class UserDaoTest {
	
	@Resource
	private UserDao userDao;

	@Test
	public void testSave() {
		User user = new User("qqqq", 1, new Date());
		userDao.save(user);
		
		User user2 = new User("zzzz", 1, new Date());
		userDao.save(user2);
	}

	@Test
	public void testQueryById() {
		User user = userDao.queryById("59ddee63dd30280a74483319");
		System.out.println(user.toString());
	}

	@Test
	public void testQueryList() {
		Query query = new Query();
		Criteria criteria = Criteria.where("age").is(23);
		query.addCriteria(criteria);
		List<User> UserList = userDao.queryList(query);
		for (User user : UserList) {
			System.out.println(user);
		}
	}

	@Test
	public void testQueryOne() {
		User user = userDao.queryOne(new Query());  
		System.out.println(user);
	}

	@Test
	public void testGetPage() {
		List<User> userList = userDao.getPage(new Query(), 0, 10);
		for (User user : userList) {
			System.out.println(user);
		}
	}

	@Test
	public void testGetPageCount() {
		Long count = userDao.getPageCount(new Query());
		System.out.println(count);
	}

	@Test
	public void testDeleteById() {
		userDao.deleteById("5747fc9c66a4732b18a10fab");
	}

	@Test
	public void testDelete() {
		User user = userDao.queryOne(new Query().addCriteria(Criteria.where("id").is("5747fc9c66a4732b18a10faa")));
		userDao.delete(user);
	}

	@Test
	public void testUpdateFirst() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateMulti() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateInser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEntityClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteQuery(){
		Criteria criteria = Criteria.where("age").is(25);
		Query query = new Query(criteria);
		userDao.delete(query);
	}
}
