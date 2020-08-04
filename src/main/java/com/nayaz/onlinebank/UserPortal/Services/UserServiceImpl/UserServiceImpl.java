package com.nayaz.onlinebank.UserPortal.Services.UserServiceImpl;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nayaz.onlinebank.UserPortal.Dao.RoleDao;
import com.nayaz.onlinebank.UserPortal.Dao.UserDao;
import com.nayaz.onlinebank.UserPortal.Entities.User;
import com.nayaz.onlinebank.UserPortal.Entities.Security.UserRole;
import com.nayaz.onlinebank.UserPortal.Services.AccountService;
import com.nayaz.onlinebank.UserPortal.Services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	AccountService accountService;
	
	
	public void save(User user) {
		 userDao.save(user);
	}
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	public boolean checkUserExists(String username, String email) {
		if(checkUsernameExists(username) || checkEmailExists(email)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkEmailExists(String email) {
		if(null != findByEmail(email)) {
			return true;
		}
		return false;
	}
	
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userDao.findByUsername(user.getUsername());
		
		if(localUser != null) {
			LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
		}else {
			String encryptedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);
		
		for(UserRole ur : userRoles) {
			roleDao.save(ur.getRole());
		}
		
		user.getUserRoles().addAll(userRoles);
		
		
		user.setPrimaryAccount(accountService.createPrimaryAccount());
		user.setSavingsAccount(accountService.createSavingsAccount());
		
		localUser = userDao.save(user);
		}
		return localUser;
		
	}

	public boolean checkUsernameExists(String username) {
		if(null != findByUsername(username)) {
			return true;
		}
		return false;
	}
	

}
