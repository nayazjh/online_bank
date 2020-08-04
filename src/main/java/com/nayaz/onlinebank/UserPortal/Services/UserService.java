package com.nayaz.onlinebank.UserPortal.Services;

import java.util.Set;

import com.nayaz.onlinebank.UserPortal.Entities.User;
import com.nayaz.onlinebank.UserPortal.Entities.Security.UserRole;

public interface UserService {
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	boolean checkUserExists(String username, String email);
	
	boolean checkUsernameExists(String username);
	
	boolean checkEmailExists(String email);
	
	void save(User user);
	
	User createUser(User user, Set<UserRole> userRoles);

}
