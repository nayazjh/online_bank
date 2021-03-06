package com.nayaz.onlinebank.UserPortal.Services.UserServiceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayaz.onlinebank.UserPortal.Dao.PrimaryAccountDao;
import com.nayaz.onlinebank.UserPortal.Dao.SavingsAccountDao;
import com.nayaz.onlinebank.UserPortal.Entities.PrimaryAccount;
import com.nayaz.onlinebank.UserPortal.Entities.SavingsAccount;
import com.nayaz.onlinebank.UserPortal.Services.AccountService;
import com.nayaz.onlinebank.UserPortal.Services.UserService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private PrimaryAccountDao primaryAccountDao;
	
	@Autowired 
	private SavingsAccountDao savingsAccountDao;
	
	@Autowired
	UserService userService;
	
	private static int nextAccountNumber = 224255668;

	public PrimaryAccount createPrimaryAccount() {
		PrimaryAccount primaryAccount = new PrimaryAccount();
		primaryAccount.setAccountBalance(new BigDecimal(0.0));
		primaryAccount.setAccountNumber(accountGen());
		
		primaryAccountDao.save(primaryAccount);
		
		return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
	}

	public SavingsAccount createSavingsAccount() {
		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount.setAccountBalance(new BigDecimal(0.0));
		savingsAccount.setAccountNumber(accountGen());
		
		savingsAccountDao.save(savingsAccount);
		
		return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
	}
	
	private int accountGen() {
		return ++ nextAccountNumber;
	}
	

}
