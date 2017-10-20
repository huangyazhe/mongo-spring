package com.lgp.mongo.dao;

import org.springframework.stereotype.Repository;

import com.lgp.mongo.model.User;

@Repository
public class UserDao extends MongoBaseDao<User> {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

}
