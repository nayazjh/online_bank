package com.nayaz.onlinebank.UserPortal.Services;

import com.nayaz.onlinebank.UserPortal.Entities.PrimaryAccount;
import com.nayaz.onlinebank.UserPortal.Entities.SavingsAccount;

public interface AccountService {
	
	PrimaryAccount createPrimaryAccount();
	SavingsAccount createSavingsAccount();

}
