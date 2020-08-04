package com.nayaz.onlinebank.UserPortal.Dao;

import org.springframework.data.repository.CrudRepository;

import com.nayaz.onlinebank.UserPortal.Entities.User;

public interface UserDao extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	User findByEmail(String email);
}
