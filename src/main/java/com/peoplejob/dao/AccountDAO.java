package com.peoplejob.dao;

import com.peoplejob.common.AbstractDAO;
import com.peoplejob.dto.account.Account;
import com.peoplejob.dto.account.AccountFilter;
import com.peoplejob.dto.response.CommonResponse;
import com.peoplejob.dto.response.LoginResponse;

public class AccountDAO extends AbstractDAO{
	
	public String Login(AccountFilter filter){
		
		return (String)selectOne("Account.login",filter);
	}
	
	public LoginResponse SetAccount(Account account){
		
		LoginResponse response = new LoginResponse();
		try{
			insert("Account.setAccount",account);
			response.setResult("Success");

		}catch(Exception e){		
			response.setReason(e.toString());
			response.setResult("Fail");
		}
		return response;
	}
	
	public Account GetAccount(AccountFilter filter){
		
		return (Account) selectOne("Account.getAccount",filter);
	}
}
