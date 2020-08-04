package com.nayaz.onlinebank.UserPortal.Services;

import com.nayaz.onlinebank.UserPortal.Entities.Security.Role;


public interface RoleService {
	
	Role findByName(String name);

}
