package com.nayaz.onlinebank.UserPortal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nayaz.onlinebank.UserPortal.Entities.PrimaryAccount;
import com.nayaz.onlinebank.UserPortal.Entities.SavingsAccount;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@RequestMapping("/primaryAccount")
	public String primaryAccount(PrimaryAccount primaryAccount) {
		return "primaryAccount";
		
	}
	
	@RequestMapping("/savingsAccount")
	public String savingsAccount(SavingsAccount savingsAccount) {
		return "savingsAccount";
		
	}
}
