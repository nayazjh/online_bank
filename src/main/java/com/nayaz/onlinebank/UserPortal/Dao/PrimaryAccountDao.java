package com.nayaz.onlinebank.UserPortal.Dao;

import org.springframework.data.repository.CrudRepository;

import com.nayaz.onlinebank.UserPortal.Entities.PrimaryAccount;

public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount, Long> {
	
	PrimaryAccount findByAccountNumber(int accountNumber);
}
