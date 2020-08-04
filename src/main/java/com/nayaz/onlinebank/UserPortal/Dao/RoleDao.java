package com.nayaz.onlinebank.UserPortal.Dao;

import org.springframework.data.repository.CrudRepository;

import com.nayaz.onlinebank.UserPortal.Entities.Security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
	
	Role findByName(String name);

}
