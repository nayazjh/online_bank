package com.nayaz.onlinebank.UserPortal.Dao;

import org.springframework.data.repository.CrudRepository;

import com.nayaz.onlinebank.UserPortal.Entities.SavingsAccount;

public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {
	
	SavingsAccount findByAccountNumber(int accountNumber);
	
}
