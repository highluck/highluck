package com.peoplejob.biz;



import com.peoplejob.dao.AccountDAO;
import com.peoplejob.dto.account.Account;
import com.peoplejob.dto.account.AccountFilter;
import com.peoplejob.dto.response.CommonResponse;
import com.peoplejob.dto.response.LoginResponse;

public class AccountBiz {
		
	private AccountDAO accountDao;

	public void setAccountDao(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}
	
	public LoginResponse Login(AccountFilter filter){
		LoginResponse response = new LoginResponse();
		String result = accountDao.Login(filter);
		
		if(result.equals("FAIL")){
			response.setReason("비밀번호가 틀렸습니다.");
			response.setResult("false");
		}
		else{
			response.setResult("true");
			response.setToken(filter.getEmail());
			response.setAccount(accountDao.GetAccount(filter));
		}	
		
		return response;
	}
	
	public LoginResponse SetAccount(Account account){
		return accountDao.SetAccount(account);
	}
	
	public Account GetAccount(AccountFilter filter){
		return accountDao.GetAccount(filter);
	}
}
